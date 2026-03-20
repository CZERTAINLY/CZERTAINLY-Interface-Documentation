package com.otilm.openapi.config.security;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Sanitizes OpenAPI specifications by removing unwanted security schemas.
 * <p>
 * Takes a set of allowed security scheme names and:
 * 1. Removes all unwanted schemes from components.securitySchemes
 * 2. Removes all references to deleted schemes from operation-level and global-level security arrays
 */
@Component
public class OpenApiSecuritySanitizer {
    private static final Logger log = LoggerFactory.getLogger(OpenApiSecuritySanitizer.class);

    /**
     * Removes unwanted security schemes from the OpenAPI object.
     * Keeps only those in the allowedSchemes set.
     */
    public void sanitizeSecuritySchemes(OpenAPI openApi, Set<String> allowedSchemes) {
        if (openApi == null || openApi.getComponents() == null) {
            log.debug("No components found in OpenAPI spec");
            return;
        }

        Set<String> validSchemes = allowedSchemes == null ? Collections.emptySet() : allowedSchemes;

        Map<String, ?> securitySchemes = openApi.getComponents().getSecuritySchemes();
        if (securitySchemes != null) {
            Set<String> schemesToRemove = new HashSet<>();

            // Identify schemes to remove
            for (String schemeName : securitySchemes.keySet()) {
                if (!validSchemes.contains(schemeName)) {
                    schemesToRemove.add(schemeName);
                }
            }

            // Remove unwanted schemes from components
            for (String schemeName : schemesToRemove) {
                openApi.getComponents().getSecuritySchemes().remove(schemeName);
                log.debug("Removed unwanted security scheme: {}", schemeName);
            }

            // Avoid emitting an empty map as `securitySchemes: {}` in YAML output.
            if (openApi.getComponents().getSecuritySchemes().isEmpty()) {
                openApi.getComponents().setSecuritySchemes(null);
            }
        }

        // Remove references to deleted schemes from all operations
        if (openApi.getPaths() != null) {
            for (PathItem pathItem : openApi.getPaths().values()) {
                removeInvalidSecurityRequirements(pathItem, validSchemes);
            }
        }

        // Remove references from global security
        if (openApi.getSecurity() != null) {
            var filteredGlobalSecurity = new ArrayList<>(openApi.getSecurity());
            filteredGlobalSecurity.removeIf(secReq -> !isValidSecurityRequirement(secReq, validSchemes));
            openApi.setSecurity(filteredGlobalSecurity);
        }

        log.debug("Sanitized security schemes. Kept: {}", validSchemes);
    }

    /**
     * Removes security requirements from a path item that reference deleted schemes.
     */
    private void removeInvalidSecurityRequirements(PathItem pathItem, Set<String> validSchemeNames) {
        for (Operation operation : pathItem.readOperationsMap().values()) {
            if (operation.getSecurity() != null) {
                var filteredOperationSecurity = new ArrayList<>(operation.getSecurity());
                filteredOperationSecurity.removeIf(secReq -> !isValidSecurityRequirement(secReq, validSchemeNames));
                operation.setSecurity(filteredOperationSecurity);
            }
        }
    }

    /**
     * Checks if a security requirement references only valid scheme names.
     * Empty security requirement is valid (means no auth required).
     */
    private boolean isValidSecurityRequirement(SecurityRequirement secReq, Set<String> validSchemeNames) {
        if (secReq == null || secReq.isEmpty()) {
            return true; // Empty security requirement is valid
        }

        // All schemes in this requirement must be in the valid set
        for (String schemeName : secReq.keySet()) {
            if (!validSchemeNames.contains(schemeName)) {
                return false;
            }
        }
        return true;
    }
}