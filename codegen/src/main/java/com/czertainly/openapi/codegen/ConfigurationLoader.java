package com.czertainly.openapi.codegen;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Loads and parses the groups.yaml configuration file.
 * Extracts interface definitions and security configuration from the configuration.
 */
public class ConfigurationLoader {

    /**
     * Security configuration loaded from groups.yaml.
     * Contains base security interfaces and legacy controllers.
     */
    public record SecurityConfiguration(
            List<String> baseSecurityInterfaces,
            List<String> legacyControllers
    ) {
    }

    /**
     * Loads the security configuration from groups.yaml.
     * Returns the base security interfaces and legacy controllers.
     */
    @SuppressWarnings("unchecked")
    public SecurityConfiguration loadSecurityConfiguration(String groupsYamlPath) throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Object> config;

        try (InputStream input = new FileInputStream(groupsYamlPath)) {
            config = yaml.load(input);
        }

        Map<String, Object> security = (Map<String, Object>) config.get("security");
        if (security == null) {
            throw new IllegalStateException("No security configuration found in groups.yaml");
        }

        List<String> baseSecurityInterfaces = (List<String>) security.get("baseSecurityInterfaces");
        List<String> legacyControllers = (List<String>) security.get("legacyControllers");

        if (baseSecurityInterfaces == null || baseSecurityInterfaces.isEmpty()) {
            throw new IllegalStateException("No baseSecurityInterfaces found in security configuration");
        }

        if (legacyControllers == null) {
            legacyControllers = Collections.emptyList();
        }

        return new SecurityConfiguration(
                List.copyOf(baseSecurityInterfaces),
                List.copyOf(legacyControllers)
        );
    }

    /**
     * Loads the groups.yaml file and returns all unique interface fully qualified names.
     */
    @SuppressWarnings("unchecked")
    public Set<String> loadInterfaces(String groupsYamlPath) throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Object> config;

        try (InputStream input = new FileInputStream(groupsYamlPath)) {
            config = yaml.load(input);
        }

        List<Map<String, Object>> groups = (List<Map<String, Object>>) config.get("groups");
        if (groups == null || groups.isEmpty()) {
            throw new IllegalStateException("No groups found in configuration");
        }

        Set<String> allInterfaces = new LinkedHashSet<>();
        for (Map<String, Object> group : groups) {
            List<String> interfaces = (List<String>) group.get("interfaces");
            if (interfaces != null) {
                allInterfaces.addAll(interfaces);
            }
        }

        return allInterfaces;
    }

    /**
     * Loads the groups.yaml file and returns the number of groups defined.
     */
    @SuppressWarnings("unchecked")
    public int getGroupCount(String groupsYamlPath) throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Object> config;

        try (InputStream input = new FileInputStream(groupsYamlPath)) {
            config = yaml.load(input);
        }

        List<Map<String, Object>> groups = (List<Map<String, Object>>) config.get("groups");
        return groups != null ? groups.size() : 0;
    }
}
