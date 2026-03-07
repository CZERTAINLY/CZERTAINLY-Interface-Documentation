package com.czertainly.openapi.codegen;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Extracts @SecurityScheme annotations from the base security controller interfaces.
 * Maps each base class to the list of security scheme names it declares.
 */
public class SecuritySchemeExtractor {

    private static final String AUTH_PROTECTED_CONTROLLER = "com.czertainly.api.interfaces.AuthProtectedController";
    private static final String AUTH_PROTECTED_CONNECTOR_CONTROLLER_V1 = "com.czertainly.api.interfaces.AuthProtectedConnectorController";
    private static final String AUTH_PROTECTED_CONNECTOR_CONTROLLER_V2 = "com.czertainly.api.interfaces.connector.common.v2.AuthProtectedConnectorController";
    private static final String NO_AUTH_CONTROLLER_V1 = "com.czertainly.api.interfaces.NoAuthController";
    private static final String NO_AUTH_CONNECTOR_CONTROLLER_V2 = "com.czertainly.api.interfaces.connector.common.v2.NoAuthConnectorController";
    private static final String LEGACY_INFO_CONTROLLER = "com.czertainly.api.interfaces.core.web.InfoController";
    private static final List<String> ALL_BASE_CLASSES = List.of(
            AUTH_PROTECTED_CONTROLLER,
            AUTH_PROTECTED_CONNECTOR_CONTROLLER_V1,
            AUTH_PROTECTED_CONNECTOR_CONTROLLER_V2,
            NO_AUTH_CONTROLLER_V1,
            NO_AUTH_CONNECTOR_CONTROLLER_V2
    );

    private final Map<String, SecuritySchemeInfo> baseClassSchemes = new HashMap<>();

    public SecuritySchemeExtractor() {
        initializeBaseClassSchemes();
    }

    /**
     * Loads and analyzes the base security controller interfaces.
     * Extracts their @SecurityScheme annotations.
     */
    private void initializeBaseClassSchemes() {
        try {
            analyzeBaseClass(AUTH_PROTECTED_CONTROLLER);
            analyzeBaseClass(AUTH_PROTECTED_CONNECTOR_CONTROLLER_V1);
            analyzeBaseClass(AUTH_PROTECTED_CONNECTOR_CONTROLLER_V2);
            analyzeBaseClass(NO_AUTH_CONTROLLER_V1);
            analyzeBaseClass(NO_AUTH_CONNECTOR_CONTROLLER_V2);
            analyzeLegacyController(LEGACY_INFO_CONTROLLER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load base security controller classes: " + e.getMessage(), e);
        }
    }

    /**
     * Analyzes a single base controller class and extracts its security schemes.
     */
    private void analyzeBaseClass(String baseClassFqn) throws ClassNotFoundException {
        Class<?> baseClass = Class.forName(baseClassFqn);
        List<String> schemeNames = new ArrayList<>();

        // Check for @SecuritySchemes annotation (can have multiple schemes)
        SecuritySchemes securitySchemes = baseClass.getAnnotation(SecuritySchemes.class);
        if (securitySchemes != null && securitySchemes.value() != null) {
            for (SecurityScheme scheme : securitySchemes.value()) {
                schemeNames.add(scheme.name());
            }
        }

        // Also check for @SecurityScheme annotation (single scheme)
        SecurityScheme securityScheme = baseClass.getAnnotation(SecurityScheme.class);
        if (securityScheme != null) {
            schemeNames.add(securityScheme.name());
        }

        baseClassSchemes.put(baseClassFqn, new SecuritySchemeInfo(baseClassFqn, schemeNames));
    }

    /**
     * Analyzes a legacy controller that does not extend any base security interface.
     * Extracts security scheme names from @SecurityRequirements annotations.
     */
    private void analyzeLegacyController(String controllerFqn) throws ClassNotFoundException {
        Class<?> controllerClass = Class.forName(controllerFqn);
        List<String> schemeNames = extractSecurityRequirements(controllerClass);

        for (var method : controllerClass.getMethods()) {
            schemeNames.addAll(extractSecurityRequirements(method));
        }

        baseClassSchemes.put(controllerFqn, new SecuritySchemeInfo(controllerFqn, schemeNames));
    }

    private List<String> extractSecurityRequirements(AnnotatedElement element) {
        List<String> schemeNames = new ArrayList<>();

        SecurityRequirements requirements = element.getAnnotation(SecurityRequirements.class);
        if (requirements != null && requirements.value() != null) {
            for (SecurityRequirement requirement : requirements.value()) {
                if (!requirement.name().isBlank()) {
                    schemeNames.add(requirement.name());
                }
            }
        }

        SecurityRequirement requirement = element.getAnnotation(SecurityRequirement.class);
        if (requirement != null && !requirement.name().isBlank()) {
            schemeNames.add(requirement.name());
        }

        return schemeNames;
    }

    /**
     * Determines which base class an interface extends.
     * Validates that it extends exactly one of the base classes,
     * except for the legacy InfoController, which is explicitly allowed.
     *
     * @param interfaceClass The interface to check
     * @return The FQN of the base security controller class
     * @throws IllegalArgumentException if the interface doesn't inherit from any base class
     */
    public String determineBaseSecurityClass(Class<?> interfaceClass) {
        if (LEGACY_INFO_CONTROLLER.equals(interfaceClass.getName())) {
            return LEGACY_INFO_CONTROLLER;
        }

        String matchedBase = null;

        // Check direct interfaces and parent interfaces
        for (Class<?> iface : interfaceClass.getInterfaces()) {
            if (isBaseSecurityClass(iface.getName())) {
                if (matchedBase != null && !matchedBase.equals(iface.getName())) {
                    throw new IllegalArgumentException(
                            "Interface " + interfaceClass.getName() +
                                    " extends multiple base security classes. This is invalid."
                    );
                }
                matchedBase = iface.getName();
            }
        }

        // Check parent interfaces transitively (skip base classes to avoid recursion errors)
        for (Class<?> iface : interfaceClass.getInterfaces()) {
            if (isBaseSecurityClass(iface.getName())) {
                continue;
            }
            String parentBase = determineBaseSecurityClass(iface);
            if (parentBase != null) {
                if (matchedBase != null && !matchedBase.equals(parentBase)) {
                    throw new IllegalArgumentException(
                            "Interface " + interfaceClass.getName() +
                                    " transitively extends multiple base security classes. This is invalid."
                    );
                }
                matchedBase = parentBase;
            }
        }

        if (matchedBase == null) {
            throw new IllegalArgumentException(
                    "Controller interface " + interfaceClass.getName() + " does not extend any of the base security interfaces: " + ALL_BASE_CLASSES +
                            ". Legacy exception allowed only for: " + LEGACY_INFO_CONTROLLER
            );
        }

        return matchedBase;
    }

    /**
     * Checks if a class is one of the base security classes.
     */
    private boolean isBaseSecurityClass(String classFqn) {
        return ALL_BASE_CLASSES.contains(classFqn);
    }

    /**
     * Gets the security scheme names for a given base class.
     */
    public List<String> getSecuritySchemesForBaseClass(String baseClassFqn) {
        SecuritySchemeInfo info = baseClassSchemes.get(baseClassFqn);
        if (info == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(info.schemeNames);
    }

    /**
     * Gets information about all base classes and their security schemes.
     */
    public Map<String, SecuritySchemeInfo> getAllBaseClassSchemes() {
        return new HashMap<>(baseClassSchemes);
    }

    /**
     * Inner class to hold information about a base class and its security schemes.
     */
    public record SecuritySchemeInfo(String baseClassFqn, List<String> schemeNames) {
        @Nonnull
        public String toString() {
            return baseClassFqn.substring(baseClassFqn.lastIndexOf('.') + 1) +
                    " → " + schemeNames;
        }
    }
}
