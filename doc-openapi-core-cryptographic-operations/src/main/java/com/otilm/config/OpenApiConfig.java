package com.otilm.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.servlet.ServletContext;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OpenApiConfig {
	
	@Autowired
	ServletContext context;

    @Value( "${api.version}" )
    private String version;
	
    @Bean
    public GroupedOpenApi clientOperationsApis() {
        return GroupedOpenApi.builder()
        		.group("core-cryptographic-operations")
                .packagesToScan("com.otilm.api.impl")
                //.pathsToMatch("/v1/**")
                .build()
                ;
    }

    @Bean
    public OpenAPI cryptographicOperationsOpenAPI() {
        Map<String, Object> logoExtension = new HashMap<>();
        Map<String, Object> logoExtensionFields = new HashMap<>();
        logoExtensionFields.put("url", "images/ilm-logo.svg");
        logoExtension.put("x-logo", logoExtensionFields);

        return new OpenAPI()
                .info(new Info().title("Cryptographic Operations API")
                        .description("REST API for Cryptographic Operations")
                        .version(version)
                        .license(new License()
                                .name("MIT License")
                                .url("https://github.com/CZERTAINLY/CZERTAINLY/blob/develop/LICENSE.md"))
                        .extensions(logoExtension)
                        .contact(new Contact()
                                .name("ILM")
                                .url("https://www.otilm.com")
                                .email("info@otilm.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("ILM Documentation")
                        .url("https://docs.otilm.com"))
                .servers(null)
                ;
    }

}
