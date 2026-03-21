package com.otilm.openapi.config.builder;

import com.otilm.openapi.config.model.CommonConfiguration;
import com.otilm.openapi.config.model.GroupConfiguration;
import com.otilm.openapi.config.util.ClassNameResolver;
import com.otilm.openapi.config.security.OpenApiSecuritySanitizer;
import com.otilm.openapi.config.security.SecuritySchemeMetadataReader;
import com.otilm.openapi.codegen.SecuritySchemeCategory;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Builds GroupedOpenApi beans from configuration
 */
@Component
public class GroupedOpenApiBuilder {
    private static final Logger log = LoggerFactory.getLogger(GroupedOpenApiBuilder.class);
    private static final String BASE_PACKAGE = "com.otilm.openapi.generated";

    private final OpenApiInfoBuilder infoBuilder;
    private final SecuritySchemeMetadataReader securitySchemeMetadataReader;
    private final OpenApiSecuritySanitizer openApiSecuritySanitizer;
    private final String apiVersion;

    @Autowired
    public GroupedOpenApiBuilder(OpenApiInfoBuilder infoBuilder,
                                 SecuritySchemeMetadataReader securitySchemeMetadataReader,
                                 OpenApiSecuritySanitizer openApiSecuritySanitizer,
                                 @Value("${api.version}") String apiVersion) {
        this.infoBuilder = infoBuilder;
        this.securitySchemeMetadataReader = securitySchemeMetadataReader;
        this.openApiSecuritySanitizer = openApiSecuritySanitizer;
        this.apiVersion = apiVersion;
    }

    /**
     * Builds a GroupedOpenApi from the group configuration
     */
    public GroupedOpenApi buildGroupedOpenApi(GroupConfiguration groupConfig, CommonConfiguration commonConfig) {
        validateGroupConfiguration(groupConfig);

        List<String> controllerClassNames = groupConfig.getInterfaces().stream()
                .map(ClassNameResolver::generateImplementationClassName)
                .toList();

        GroupedOpenApi.Builder builder = GroupedOpenApi.builder()
                .group(groupConfig.getGroupName())
                .packagesToScan(BASE_PACKAGE)
                .addOpenApiCustomizer(openApi -> customizeOpenApi(openApi, groupConfig, commonConfig))
                .displayName(getDisplayName(groupConfig))
                .addOpenApiMethodFilter(method -> filterMethod(method, controllerClassNames));

        logGroupRegistration(groupConfig, controllerClassNames);

        return builder.build();
    }

    /**
     * Validates that the group configuration has required data
     */
    private void validateGroupConfiguration(GroupConfiguration groupConfig) {
        if (groupConfig.getInterfaces().isEmpty()) {
            log.warn("Group {} has no interfaces, skipping", groupConfig.getGroupName());
            throw new IllegalArgumentException("Group has no interfaces");
        }
    }

    /**
     * Customizes the OpenAPI object for a specific group.
     * Applies group-specific info and sanitizes security schemas based on group's interfaces.
     */
    private void customizeOpenApi(OpenAPI openApi, GroupConfiguration groupConfig, CommonConfiguration commonConfig) {
        Info info = infoBuilder.buildInfo(
                groupConfig.getTitle(),
                groupConfig.getDescription(),
                apiVersion,
                commonConfig
        );
        openApi.info(info);

        infoBuilder.addCommonElements(openApi, commonConfig, groupConfig.getServerUrl());

        // Apply group-specific extensions to the Info object
        if (!groupConfig.getExtensions().isEmpty()) {
            if (info.getExtensions() == null) {
                info.setExtensions(new java.util.HashMap<>());
            }
            // Merge group-specific extensions (they override common extensions if there's a conflict)
            info.getExtensions().putAll(groupConfig.getExtensions());
            log.debug("Applied {} extension(s) to group {}: {}",
                    groupConfig.getExtensions().size(),
                    groupConfig.getGroupName(),
                    groupConfig.getExtensions().keySet());
        }

        // Determine which security schemes are allowed for this group's interfaces
        Set<String> allowedSchemes = determineAllowedSecuritySchemes(groupConfig);

        // Sanitize: remove unwanted security schemes
        openApiSecuritySanitizer.sanitizeSecuritySchemes(openApi, allowedSchemes);
    }

    /**
     * Determines which security schemes are allowed for a group based on its interfaces.
     * Collects all unique security schemes from all base classes used by the group's interfaces.
     */
    private Set<String> determineAllowedSecuritySchemes(GroupConfiguration groupConfig) {
        Set<String> allowedSchemes = new HashSet<>();

        // For each interface, find its base class and add allowed schemes
        for (String interfaceFqn : groupConfig.getInterfaces()) {
            // The base class info was extracted during codegen and stored in annotations
            String generatedClassName = ClassNameResolver.generateImplementationClassName(interfaceFqn);
            try {
                Class<?> generatedClass = Class.forName(BASE_PACKAGE + "." + generatedClassName);
                SecuritySchemeCategory annotation = generatedClass.getAnnotation(SecuritySchemeCategory.class);

                if (annotation != null) {
                    String baseClass = annotation.baseClass();
                    Set<String> schemesForBase = securitySchemeMetadataReader.getSchemesForBaseClass(baseClass);
                    allowedSchemes.addAll(schemesForBase);

                    log.debug("Interface {} → base class {}, schemes: {}",
                            interfaceFqn,
                            baseClass.substring(baseClass.lastIndexOf('.') + 1),
                            schemesForBase
                    );
                }
            } catch (ClassNotFoundException e) {
                log.warn("Could not load generated class for interface {}: {}", interfaceFqn, e.getMessage());
            }
        }

        log.debug("Group {} allowed security schemes: {}", groupConfig.getGroupName(), allowedSchemes);
        return allowedSchemes;
    }

    /**
     * Gets the display name for a group
     */
    private String getDisplayName(GroupConfiguration groupConfig) {
        return groupConfig.getTitle() != null ? groupConfig.getTitle() : groupConfig.getGroupName();
    }

    /**
     * Filters methods to include only those from the group's controllers
     */
    private boolean filterMethod(java.lang.reflect.Method method, List<String> controllerClassNames) {
        String className = method.getDeclaringClass().getSimpleName();
        return controllerClassNames.contains(className);
    }

    /**
     * Logs that a group has been registered
     */
    private void logGroupRegistration(GroupConfiguration groupConfig, List<String> controllerClassNames) {
        log.info("Registered OpenAPI group: {} ({} interfaces: {}) - {}",
                groupConfig.getGroupName(),
                groupConfig.getInterfaces().size(),
                controllerClassNames,
                groupConfig.getTitle()
        );
    }
}