package com.czertainly.openapi.config;

import com.czertainly.openapi.config.builder.GroupedOpenApiBuilder;
import com.czertainly.openapi.config.loader.GroupsConfigurationLoader;
import com.czertainly.openapi.config.model.CommonConfiguration;
import com.czertainly.openapi.config.model.GroupConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Dynamic OpenAPI configuration that reads group definitions from groups.yaml
 * and creates GroupedOpenApi beans for each group.
 * 
 * This class delegates configuration loading and building to specialized components
 * for better separation of concerns and maintainability.
 */
@Configuration
public class OpenApiConfig {

    private final GroupsConfigurationLoader configurationLoader;
    private final GroupedOpenApiBuilder groupedOpenApiBuilder;

    @Autowired
    public OpenApiConfig(GroupsConfigurationLoader configurationLoader, GroupedOpenApiBuilder groupedOpenApiBuilder) {
        this.configurationLoader = configurationLoader;
        this.groupedOpenApiBuilder = groupedOpenApiBuilder;
    }

    /**
     * Creates GroupedOpenApi beans dynamically for each group defined in groups.yaml.
     * Each group is configured to include only the controllers that implement
     * its specified interfaces.
     */
    @Bean
    public List<GroupedOpenApi> groupedOpenApis() {
        List<GroupedOpenApi> groups = new ArrayList<>();
        CommonConfiguration commonConfig = configurationLoader.getCommonConfiguration();

        for (GroupConfiguration groupConfig : configurationLoader.getGroups()) {
            try {
                GroupedOpenApi groupedOpenApi = groupedOpenApiBuilder.buildGroupedOpenApi(groupConfig, commonConfig);
                groups.add(groupedOpenApi);
            } catch (IllegalArgumentException e) {
                // Skip groups with invalid configuration (e.g., no interfaces)
                // Error is already logged in the builder
            }
        }

        return groups;
    }
}
