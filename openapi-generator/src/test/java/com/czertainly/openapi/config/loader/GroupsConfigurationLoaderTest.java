package com.czertainly.openapi.config.loader;

import com.czertainly.openapi.Application;
import com.czertainly.openapi.config.model.GroupConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Application.class)
class GroupsConfigurationLoaderTest {

    private static Path configPath;

    @Autowired
    private GroupsConfigurationLoader loader;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("openapi.groups.config.path", () -> ensureConfigPath().toString());
        registry.add("api.version", () -> "test-version");
    }

    private static synchronized Path ensureConfigPath() {
        if (configPath != null) {
            return configPath;
        }
        try {
            configPath = Files.createTempFile("groups-valid-ref", ".yaml");
            byte[] content = new ClassPathResource("groups-valid-ref.yaml").getInputStream().readAllBytes();
            Files.write(configPath, content);
            configPath.toFile().deleteOnExit();
            return configPath;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    void shouldResolveTopLevelBacktickReferencesInGroupAndCommonExtensions() {
        Map<String, Object> commonExtensions = loader.getCommonConfiguration().getExtensions();
        assertInstanceOf(Map.class, commonExtensions.get("x-common-profile"));

        GroupConfiguration group = loader.getGroups().stream()
                .filter(g -> "test-group".equals(g.getGroupName()))
                .findFirst()
                .orElseThrow();

        assertInstanceOf(List.class, group.getExtensions().get("x-group-profile"));
        assertEquals("plain-string", group.getExtensions().get("x-literal"));
    }


    @Test
    void shouldFailApplicationStartupOnInvalidBacktickExtensionValue() throws IOException {
        Path configPath = Files.createTempFile("groups-invalid-ref", ".yaml");
        byte[] content = new ClassPathResource("groups-invalid-ref.yaml").getInputStream().readAllBytes();
        Files.write(configPath, content);
        configPath.toFile().deleteOnExit();

        try (ConfigurableApplicationContext ignored = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .properties(
                        "openapi.groups.config.path=" + configPath,
                        "api.version=test-version"
                )
                .run()) {
            fail("Application startup should fail for invalid extension backtick format");
        } catch (Exception e) {
            assertTrue(containsMessage(e, "whole-string references"));
        }
    }

    private boolean containsMessage(Throwable throwable, String expectedFragment) {
        Throwable current = throwable;
        while (current != null) {
            if (current.getMessage() != null && current.getMessage().contains(expectedFragment)) {
                return true;
            }
            current = current.getCause();
        }
        return false;
    }
}