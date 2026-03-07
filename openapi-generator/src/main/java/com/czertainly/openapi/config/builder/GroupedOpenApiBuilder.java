package com.czertainly.openapi.config.builder;

import com.czertainly.openapi.config.model.CommonConfiguration;
import com.czertainly.openapi.config.model.GroupConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Builds GroupedOpenApi beans from configuration
 */
@Component
public class GroupedOpenApiBuilder {
    private static final Logger log = LoggerFactory.getLogger(GroupedOpenApiBuilder.class);
    private static final String BASE_PACKAGE = "com.czertainly.openapi.generated";

    private final OpenApiInfoBuilder infoBuilder;
    private final String apiVersion;

    @Autowired
    public GroupedOpenApiBuilder(OpenApiInfoBuilder infoBuilder, @Value("${api.version}") String apiVersion) {
        this.infoBuilder = infoBuilder;
        this.apiVersion = apiVersion;
    }

    /**
     * Builds a GroupedOpenApi from the group configuration
     */
    public GroupedOpenApi buildGroupedOpenApi(GroupConfiguration groupConfig, CommonConfiguration commonConfig) {
        validateGroupConfiguration(groupConfig);

        List<String> controllerClassNames = groupConfig.getControllerClassNames();

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
        if (groupConfig.getInterfaces() == null || groupConfig.getInterfaces().isEmpty()) {
            log.warn("Group {} has no interfaces, skipping", groupConfig.getGroupName());
            throw new IllegalArgumentException("Group has no interfaces");
        }
    }

    /**
     * Customizes the OpenAPI object for a specific group
     */
    private void customizeOpenApi(OpenAPI openApi, GroupConfiguration groupConfig, CommonConfiguration commonConfig) {
        Info info = infoBuilder.buildInfo(
                groupConfig.getTitle(),
                groupConfig.getDescription(),
                apiVersion,
                commonConfig
        );
        openApi.info(info);

        infoBuilder.addCommonElements(openApi, commonConfig);
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