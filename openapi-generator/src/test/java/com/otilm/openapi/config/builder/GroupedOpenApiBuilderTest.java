package com.otilm.openapi.config.builder;

import com.otilm.openapi.config.model.CommonConfiguration;
import com.otilm.openapi.config.model.GroupConfiguration;
import com.otilm.openapi.config.security.OpenApiSecuritySanitizer;
import com.otilm.openapi.config.security.SecuritySchemeMetadataReader;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupedOpenApiBuilderTest {

    @Mock
    private OpenApiInfoBuilder infoBuilder;

    @Mock
    private SecuritySchemeMetadataReader securitySchemeMetadataReader;

    @Mock
    private OpenApiSecuritySanitizer openApiSecuritySanitizer;

    private GroupedOpenApiBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new GroupedOpenApiBuilder(
                infoBuilder,
                securitySchemeMetadataReader,
                openApiSecuritySanitizer,
                "1.0.0"
        );
    }

    @Test
    void shouldApplyEmptySecurityWhenConfiguredWithEmptyList() {
        // Given: Group configuration with explicit empty security
        GroupConfiguration groupConfig = new GroupConfiguration();
        groupConfig.setId("test-group");
        groupConfig.setGroupName("test");
        groupConfig.setTitle("Test API");
        groupConfig.setDescription("Test Description");
        groupConfig.setInterfaces(new ArrayList<>(List.of("com.example.TestController")));
        groupConfig.setSecurity(Collections.emptyList());

        CommonConfiguration commonConfig = new CommonConfiguration();

        // Create OpenAPI with operation-level security
        OpenAPI openApi = new OpenAPI()
                .paths(new Paths()
                        .addPathItem("/v1/test", new PathItem()
                                .get(new Operation()
                                        .addSecurityItem(new SecurityRequirement().addList("BearerJWTAuth")))));

        // Mock behavior
        when(infoBuilder.buildInfo(anyString(), anyString(), anyString(), any())).thenReturn(new io.swagger.v3.oas.models.info.Info());
        doNothing().when(infoBuilder).addCommonElements(any(), any(), any());

        // When: We call the customizer (simulate what happens during group building)
        // Access the customizer through reflection since it's private
        try {
            var customizerMethod = GroupedOpenApiBuilder.class.getDeclaredMethod(
                    "customizeOpenApi", OpenAPI.class, GroupConfiguration.class, CommonConfiguration.class);
            customizerMethod.setAccessible(true);
            customizerMethod.invoke(builder, openApi, groupConfig, commonConfig);
        } catch (Exception e) {
            fail("Failed to invoke customizeOpenApi: " + e.getMessage());
        }

        // Then: Document-level security should be empty list
        assertNotNull(openApi.getSecurity(), "Security should not be null");
        assertTrue(openApi.getSecurity().isEmpty(), "Security should be empty list");

        // And: Operation-level security should be removed
        Operation getOperation = openApi.getPaths().get("/v1/test").getGet();
        assertNull(getOperation.getSecurity(), "Operation-level security should be removed when document-level is []");

        // And: Sanitizer should NOT be called (explicit security bypasses it)
        verify(openApiSecuritySanitizer, never()).sanitizeSecuritySchemes(any(), any());
    }

    @Test
    void shouldApplyExplicitSecurityRequirements() {
        // Given: Group configuration with explicit security requirements
        GroupConfiguration groupConfig = new GroupConfiguration();
        groupConfig.setId("test-group");
        groupConfig.setGroupName("test");
        groupConfig.setTitle("Test API");
        groupConfig.setDescription("Test Description");
        groupConfig.setInterfaces(new ArrayList<>(List.of("com.example.TestController")));

        // Configure explicit security: [{BearerJWTAuth: []}]
        List<Map<String, List<String>>> security = new ArrayList<>();
        Map<String, List<String>> bearerAuth = new HashMap<>();
        bearerAuth.put("BearerJWTAuth", Collections.emptyList());
        security.add(bearerAuth);
        groupConfig.setSecurity(security);

        CommonConfiguration commonConfig = new CommonConfiguration();
        OpenAPI openApi = new OpenAPI();

        // Mock behavior
        when(infoBuilder.buildInfo(anyString(), anyString(), anyString(), any())).thenReturn(new io.swagger.v3.oas.models.info.Info());
        doNothing().when(infoBuilder).addCommonElements(any(), any(), any());

        // When: Customize OpenAPI
        try {
            var customizerMethod = GroupedOpenApiBuilder.class.getDeclaredMethod(
                    "customizeOpenApi", OpenAPI.class, GroupConfiguration.class, CommonConfiguration.class);
            customizerMethod.setAccessible(true);
            customizerMethod.invoke(builder, openApi, groupConfig, commonConfig);
        } catch (Exception e) {
            fail("Failed to invoke customizeOpenApi: " + e.getMessage());
        }

        // Then: Document-level security should contain the requirement
        assertNotNull(openApi.getSecurity());
        assertEquals(1, openApi.getSecurity().size());
        assertTrue(openApi.getSecurity().get(0).containsKey("BearerJWTAuth"));

        // And: Sanitizer should NOT be called
        verify(openApiSecuritySanitizer, never()).sanitizeSecuritySchemes(any(), any());
    }

    @Test
    void shouldUseSanitizerWhenNoExplicitSecurityConfigured() {
        // Given: Group configuration WITHOUT explicit security
        GroupConfiguration groupConfig = new GroupConfiguration();
        groupConfig.setId("test-group");
        groupConfig.setGroupName("test");
        groupConfig.setTitle("Test API");
        groupConfig.setDescription("Test Description");
        groupConfig.setInterfaces(new ArrayList<>(List.of("com.example.TestController")));
        // No security configured (null)

        CommonConfiguration commonConfig = new CommonConfiguration();
        OpenAPI openApi = new OpenAPI();

        // Mock behavior
        when(infoBuilder.buildInfo(anyString(), anyString(), anyString(), any())).thenReturn(new io.swagger.v3.oas.models.info.Info());
        doNothing().when(infoBuilder).addCommonElements(any(), any(), any());
        doNothing().when(openApiSecuritySanitizer).sanitizeSecuritySchemes(any(), any());

        // When: Customize OpenAPI
        try {
            var customizerMethod = GroupedOpenApiBuilder.class.getDeclaredMethod(
                    "customizeOpenApi", OpenAPI.class, GroupConfiguration.class, CommonConfiguration.class);
            customizerMethod.setAccessible(true);
            customizerMethod.invoke(builder, openApi, groupConfig, commonConfig);
        } catch (Exception e) {
            fail("Failed to invoke customizeOpenApi: " + e.getMessage());
        }

        // Then: Sanitizer should be called (default behavior)
        verify(openApiSecuritySanitizer, times(1)).sanitizeSecuritySchemes(eq(openApi), any());
    }

    @Test
    void shouldValidateGroupConfiguration() {
        // Given: Group configuration with no interfaces
        GroupConfiguration groupConfig = new GroupConfiguration();
        groupConfig.setId("test-group");
        groupConfig.setGroupName("test");
        groupConfig.setInterfaces(Collections.emptyList());

        CommonConfiguration commonConfig = new CommonConfiguration();

        // When/Then: Should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            builder.buildGroupedOpenApi(groupConfig, commonConfig);
        });
    }
}
