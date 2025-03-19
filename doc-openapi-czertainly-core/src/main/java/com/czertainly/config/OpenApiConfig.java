package com.czertainly.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;
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
import java.util.List;
import java.util.Map;

// example how to override servers and security schemas to not generate additional code to handle headers for Auth in generated API files
@Configuration
@SecuritySchemes(value = {
        @SecurityScheme(
                name = "DummyAuth",
                type = SecuritySchemeType.HTTP,
                scheme = "Basic",
                description = "No authentication"
        )
})
@OpenAPIDefinition(
        servers = {
                @Server(
                        url = "https://demo.czertainly.online/api",
                        description = "CZERTAINLY Demo server"
                )
        }
)
public class OpenApiConfig {
	
	@Autowired
    ServletContext context;

    @Value( "${api.version}" )
    private String version;
	
    @Bean
    public GroupedOpenApi authorityApis() {
        return GroupedOpenApi.builder()
        		.group("czertainly-core")
                .packagesToScan("com.czertainly.api.impl")
                //.pathsToMatch("/v1/**")
                .build()
                ;
    }

    @Bean
    public OpenAPI authorityOpenAPI() {
        Map<String, Object> logoExtension = new HashMap<>();
        Map<String, Object> logoExtensionFields = new HashMap<>();
        logoExtensionFields.put("url", "images/czertainly_color_H.svg");
        logoExtension.put("x-logo", logoExtensionFields);

        return new OpenAPI()
                .info(new Info().title("CZERTAINLY Core API")
                        .description("REST API for CZERTAINLY Core")
                        .version(version)
                        .license(new License()
                                .name("MIT License")
                                .url("https://github.com/CZERTAINLY/CZERTAINLY/blob/develop/LICENSE.md"))
                        .extensions(logoExtension)
                        .contact(new Contact()
                                .name("CZERTAINLY")
                                .url("https://www.czertainly.com")
                                .email("info@czertainly.com")))
                .security(List.of())
                .externalDocs(new ExternalDocumentation()
                        .description("CZERTAINLY Documentation")
                        .url("https://docs.czertainly.com"))
                .servers(null)
                ;
    }

}
