package com.czertainly.config;

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
    public GroupedOpenApi raProfileApis() {
        return GroupedOpenApi.builder()
        		.group("core-ra-profile")
                .packagesToScan("com.czertainly.api.impl")
                //.pathsToMatch("/v1/**")
                .build()
                ;
    }

    @Bean
    public OpenAPI raProfileOpenAPI() {
        Map<String, Object> logoExtension = new HashMap<>();
        Map<String, Object> logoExtensionFields = new HashMap<>();
        logoExtensionFields.put("url", "images/czertainly_color_H.svg");
        logoExtension.put("x-logo", logoExtensionFields);

        return new OpenAPI()
                .info(new Info().title("CZERTAINLY RA Profile API")
                        .description("REST API for managing RA Profiles in the platform")
                        .version(version)
                        .license(new License()
                                .name("MIT License")
                                .url("https://github.com/CZERTAINLY/CZERTAINLY/blob/develop/LICENSE.md"))
                        .extensions(logoExtension)
                        .contact(new Contact()
                                .name("CZERTAINLY")
                                .url("https://www.czertainly.com")
                                .email("info@czertainly.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("CZERTAINLY Documentation")
                        .url("https://docs.czertainly.com"))
                .servers(null)
                ;
    }

}
