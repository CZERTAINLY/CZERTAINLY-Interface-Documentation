package com.otilm.openapi.config.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OpenApiSecuritySanitizerTest {

    private final OpenApiSecuritySanitizer sanitizer = new OpenApiSecuritySanitizer();

    @Test
    void shouldRemoveEmptySecuritySchemesAfterFilteringAllSchemesOut() {
        OpenAPI openApi = new OpenAPI()
                .components(new Components()
                        .addSchemas("Dummy", new Schema<>())
                        .addSecuritySchemes("BearerJWTAuth", new SecurityScheme().type(SecurityScheme.Type.HTTP))
                        .addSecuritySchemes("SessionAuth", new SecurityScheme().type(SecurityScheme.Type.APIKEY)))
                .paths(new Paths().addPathItem("/v1/test", new PathItem().get(new Operation()
                        .security(List.of(
                                new SecurityRequirement().addList("BearerJWTAuth"),
                                new SecurityRequirement().addList("SessionAuth")
                        )))));

        sanitizer.sanitizeSecuritySchemes(openApi, Set.of());

        assertNotNull(openApi.getComponents(), "Components should remain present");
        assertNotNull(openApi.getComponents().getSchemas(), "Unrelated component sections should remain untouched");
        assertNull(openApi.getComponents().getSecuritySchemes(), "Empty securitySchemes map should not be emitted");

        List<SecurityRequirement> operationSecurity = openApi.getPaths().get("/v1/test").getGet().getSecurity();
        assertNotNull(operationSecurity);
        assertTrue(operationSecurity.isEmpty(), "Invalid operation security requirements should be removed");
    }

    @Test
    void shouldRemovePreExistingEmptySecuritySchemesMap() {
        OpenAPI openApi = new OpenAPI()
                .components(new Components()
                        .schemas(Map.of("Dummy", new Schema<>()))
                        .securitySchemes(Map.of()));

        sanitizer.sanitizeSecuritySchemes(openApi, Set.of("BearerJWTAuth"));

        assertNull(openApi.getComponents().getSecuritySchemes(), "Pre-existing empty map should be normalized to null");
        assertNotNull(openApi.getComponents().getSchemas(), "Schemas should remain untouched");
    }

    @Test
    void shouldKeepAllowedSecuritySchemes() {
        OpenAPI openApi = new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("BearerJWTAuth", new SecurityScheme().type(SecurityScheme.Type.HTTP))
                        .addSecuritySchemes("SessionAuth", new SecurityScheme().type(SecurityScheme.Type.APIKEY)));

        sanitizer.sanitizeSecuritySchemes(openApi, Set.of("BearerJWTAuth"));

        assertNotNull(openApi.getComponents().getSecuritySchemes());
        assertEquals(Set.of("BearerJWTAuth"), openApi.getComponents().getSecuritySchemes().keySet());
    }
}
