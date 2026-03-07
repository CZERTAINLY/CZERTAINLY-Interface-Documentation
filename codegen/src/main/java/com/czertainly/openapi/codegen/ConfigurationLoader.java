package com.czertainly.openapi.codegen;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Loads and parses the groups.yaml configuration file.
 * Extracts interface definitions from the configuration.
 */
public class ConfigurationLoader {

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
