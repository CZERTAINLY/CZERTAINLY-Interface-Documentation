package com.czertainly.openapi.config.builder;

import com.czertainly.openapi.config.model.CommonConfiguration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Builds OpenAPI objects with common configuration elements
 */
@Component
public class OpenApiInfoBuilder {

    /**
     * Builds Info object with common configuration elements
     */
    public Info buildInfo(String title, String description, String version, CommonConfiguration commonConfig) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }

        Info info = new Info()
                .title(title)
                .description(description)
                .version(version);

        addLogo(info, commonConfig);
        addLicense(info, commonConfig);
        addContact(info, commonConfig);

        return info;
    }

    /**
     * Adds logo extension to Info object
     */
    private void addLogo(Info info, CommonConfiguration commonConfig) {
        CommonConfiguration.LogoConfiguration logo = commonConfig.getLogo();
        if (logo != null && logo.getUrl() != null) {
            Map<String, Object> logoExtension = new HashMap<>();
            Map<String, Object> logoExtensionFields = new HashMap<>();
            logoExtensionFields.put("url", logo.getUrl());
            logoExtension.put("x-logo", logoExtensionFields);
            info.extensions(logoExtension);
        }
    }

    /**
     * Adds license to Info object
     */
    private void addLicense(Info info, CommonConfiguration commonConfig) {
        CommonConfiguration.LicenseConfiguration license = commonConfig.getLicense();
        if (license != null) {
            info.license(new License()
                    .name(license.getName())
                    .url(license.getUrl()));
        }
    }

    /**
     * Adds contact to Info object
     */
    private void addContact(Info info, CommonConfiguration commonConfig) {
        CommonConfiguration.ContactConfiguration contact = commonConfig.getContact();
        if (contact != null) {
            info.contact(new Contact()
                    .name(contact.getName())
                    .url(contact.getUrl())
                    .email(contact.getEmail()));
        }
    }

    /**
     * Adds common elements to OpenAPI object
     */
    public void addCommonElements(OpenAPI openAPI, CommonConfiguration commonConfig) {
        addServers(openAPI, commonConfig);
        addExternalDocs(openAPI, commonConfig);
    }

    /**
     * Adds servers to OpenAPI object
     */
    private void addServers(OpenAPI openAPI, CommonConfiguration commonConfig) {
        List<CommonConfiguration.ServerConfiguration> servers = commonConfig.getServers();
        if (servers != null && !servers.isEmpty()) {
            List<Server> serverList = servers.stream()
                    .map(this::buildServer)
                    .toList();
            openAPI.servers(serverList);
        } else {
            openAPI.servers(null);
        }
    }

    /**
     * Builds a Server object from configuration
     */
    private Server buildServer(CommonConfiguration.ServerConfiguration serverConfig) {
        return new Server()
                .url(serverConfig.getUrl())
                .description(serverConfig.getDescription());
    }

    /**
     * Adds external documentation to OpenAPI object
     */
    private void addExternalDocs(OpenAPI openAPI, CommonConfiguration commonConfig) {
        CommonConfiguration.ExternalDocsConfiguration externalDocs = commonConfig.getExternalDocs();
        if (externalDocs != null) {
            openAPI.externalDocs(new ExternalDocumentation()
                    .description(externalDocs.getDescription())
                    .url(externalDocs.getUrl()));
        }
    }
}
