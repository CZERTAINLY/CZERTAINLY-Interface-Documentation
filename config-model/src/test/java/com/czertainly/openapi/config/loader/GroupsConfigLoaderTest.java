package com.czertainly.openapi.config.loader;

import com.czertainly.openapi.config.model.GroupsConfig;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GroupsConfigLoaderTest {

    @Test
    void testLoadFromClasspath() {
        GroupsConfigLoader loader = new GroupsConfigLoader();
        GroupsConfig config = loader.loadFromClasspath("test-groups.yaml");
        assertNotNull(config);
        assertEquals("Apache 2.0", config.getCommon().getLicense().getName());
    }

    @Test
    void testLoadFromFilesystem() throws Exception {
        GroupsConfigLoader loader = new GroupsConfigLoader();
        Path tempFile = Files.createTempFile("groups-test", ".yaml");
        try {
            String content = "common:\n  license:\n    name: MIT\ngroups: []";
            Files.writeString(tempFile, content);

            GroupsConfig config = loader.loadFromFilesystem(tempFile.toString());
            assertNotNull(config);
            assertEquals("MIT", config.getCommon().getLicense().getName());
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    void testLoadDefault() throws Exception {
        GroupsConfigLoader loader = new GroupsConfigLoader();
        // Since we are in the project root, groups.yaml should exist or we can mock it
        // For testing purposes, let's create a temporary groups.yaml in the current directory if it doesn't exist
        // or just rely on the fact that it exists in the repo
        GroupsConfig config = loader.load();
        assertNotNull(config);
    }

    @Test
    void testLoadConfiguration() {
        GroupsConfigLoader loader = new GroupsConfigLoader();
        GroupsConfig config = loader.loadFromClasspath("/test-groups.yaml");

        assertNotNull(config);
        assertNotNull(config.getCommon());
        assertEquals("https://example.com/logo.png", config.getCommon().getLogo().getUrl());
        assertEquals("Apache 2.0", config.getCommon().getLicense().getName());
        assertEquals("support@example.com", config.getCommon().getContact().getEmail());
        assertEquals(1, config.getCommon().getServers().size());
        assertEquals("https://api.example.com", config.getCommon().getServers().get(0).getUrl());

        assertEquals(1, config.getGroups().size());
        assertEquals("group1", config.getGroups().get(0).getId());
        assertEquals(2, config.getGroups().get(0).getInterfaces().size());
        assertTrue(config.getGroups().get(0).getInterfaces().contains("com.example.Interface1"));
        assertEquals("value", config.getGroups().get(0).getExtensions().get("x-test"));
        Object resolved = config.getGroups().get(0).getExtensions().get("x-resolved");
        assertTrue(resolved instanceof java.util.Map);
        assertEquals(1, ((java.util.Map<?, ?>) resolved).get("version"));

        assertNotNull(config.getSecurity());
        assertEquals(1, config.getSecurity().baseSecurityInterfaces().size());
        assertEquals("com.czertainly.openapi.BaseInterface", config.getSecurity().baseSecurityInterfaces().get(0));
        assertEquals(1, config.getSecurity().legacyControllers().size());
        assertEquals("com.example.LegacyController", config.getSecurity().legacyControllers().get(0));
    }

    @Test
    void testLoadEmptySecurity() {
        GroupsConfigLoader loader = new GroupsConfigLoader();
        String yaml = "groups: []";
        java.util.Map<String, Object> raw = new org.yaml.snakeyaml.Yaml().load(yaml);
        GroupsConfig config = loader.parse(raw);

        assertNotNull(config.getSecurity());
        assertTrue(config.getSecurity().baseSecurityInterfaces().isEmpty());
        assertTrue(config.getSecurity().legacyControllers().isEmpty());
    }
}
