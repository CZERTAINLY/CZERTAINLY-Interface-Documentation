package com.czertainly.openapi.config.loader;

import com.czertainly.openapi.config.model.CommonConfiguration;
import com.czertainly.openapi.config.model.GroupConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Loads and parses the groups.yaml configuration file
 */
@Component
public class GroupsConfigurationLoader {
    private static final Logger log = LoggerFactory.getLogger(GroupsConfigurationLoader.class);
    private static final List<String> GROUPS_YAML_PATHS = List.of("groups.yaml", "../groups.yaml");
    private static final String GROUPS_YAML_CLASSPATH = "groups.yaml";

    private List<GroupConfiguration> groups;
    private CommonConfiguration commonConfig;

    public GroupsConfigurationLoader() {
        loadConfiguration();
    }

    /**
     * Loads the configuration from groups.yaml
     */
    private void loadConfiguration() {
        try {
            Yaml yaml = new Yaml();
            InputStream input = getConfigurationInputStream();

            if (input == null) {
                throw new IllegalStateException("Cannot find groups.yaml configuration file");
            }

            Map<String, Object> rawConfig = yaml.load(input);
            input.close();

            parseConfiguration(rawConfig);
            log.info("Loaded OpenAPI configuration from groups.yaml");
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load groups.yaml configuration", e);
        }
    }

    /**
     * Gets the input stream for the configuration file
     */
    private InputStream getConfigurationInputStream() throws Exception {
        // Try to load from the file system first (for Maven build)
        for (String path : GROUPS_YAML_PATHS) {
            if (Files.exists(Paths.get(path))) {
                return Files.newInputStream(Paths.get(path));
            }
        }

        // Fallback to classpath
        return getClass().getClassLoader().getResourceAsStream(GROUPS_YAML_CLASSPATH);
    }

    /**
     * Parses the raw configuration into typed objects
     */
    @SuppressWarnings("unchecked")
    private void parseConfiguration(Map<String, Object> rawConfig) {
        // Parse common configuration
        Map<String, Object> rawCommonConfig = (Map<String, Object>) rawConfig.get("common");
        this.commonConfig = parseCommonConfiguration(rawCommonConfig);

        // Parse groups
        List<Map<String, Object>> rawGroups = (List<Map<String, Object>>) rawConfig.get("groups");
        this.groups = parseGroups(rawGroups);
    }

    /**
     * Parses the common configuration section
     */
    @SuppressWarnings("unchecked")
    private CommonConfiguration parseCommonConfiguration(Map<String, Object> rawCommonConfig) {
        if (rawCommonConfig == null) {
            return new CommonConfiguration();
        }

        CommonConfiguration config = new CommonConfiguration();

        // Parse logo
        Map<String, Object> logoMap = (Map<String, Object>) rawCommonConfig.get("logo");
        if (logoMap != null) {
            CommonConfiguration.LogoConfiguration logo = new CommonConfiguration.LogoConfiguration();
            logo.setUrl((String) logoMap.get("url"));
            config.setLogo(logo);
        }

        // Parse license
        Map<String, Object> licenseMap = (Map<String, Object>) rawCommonConfig.get("license");
        if (licenseMap != null) {
            CommonConfiguration.LicenseConfiguration license = new CommonConfiguration.LicenseConfiguration();
            license.setName((String) licenseMap.get("name"));
            license.setUrl((String) licenseMap.get("url"));
            config.setLicense(license);
        }

        // Parse contact
        Map<String, Object> contactMap = (Map<String, Object>) rawCommonConfig.get("contact");
        if (contactMap != null) {
            CommonConfiguration.ContactConfiguration contact = new CommonConfiguration.ContactConfiguration();
            contact.setName((String) contactMap.get("name"));
            contact.setUrl((String) contactMap.get("url"));
            contact.setEmail((String) contactMap.get("email"));
            config.setContact(contact);
        }

        // Parse external docs
        Map<String, Object> externalDocsMap = (Map<String, Object>) rawCommonConfig.get("externalDocs");
        if (externalDocsMap != null) {
            CommonConfiguration.ExternalDocsConfiguration externalDocs = new CommonConfiguration.ExternalDocsConfiguration();
            externalDocs.setDescription((String) externalDocsMap.get("description"));
            externalDocs.setUrl((String) externalDocsMap.get("url"));
            config.setExternalDocs(externalDocs);
        }

        // Parse servers
        List<Map<String, Object>> serversMap = (List<Map<String, Object>>) rawCommonConfig.get("servers");
        if (serversMap != null) {
            List<CommonConfiguration.ServerConfiguration> servers = serversMap.stream()
                    .map(this::parseServerConfiguration)
                    .toList();
            config.setServers(servers);
        }

        // Parse extensions
        Map<String, Object> extensionsMap = (Map<String, Object>) rawCommonConfig.get("extensions");
        if (extensionsMap != null) {
            config.setExtensions(extensionsMap);
        }

        return config;
    }

    /**
     * Parses a server configuration
     */
    private CommonConfiguration.ServerConfiguration parseServerConfiguration(Map<String, Object> serverMap) {
        CommonConfiguration.ServerConfiguration server = new CommonConfiguration.ServerConfiguration();
        server.setUrl((String) serverMap.get("url"));
        server.setDescription((String) serverMap.get("description"));
        return server;
    }

    /**
     * Parses the groups section
     */
    @SuppressWarnings("unchecked")
    private List<GroupConfiguration> parseGroups(List<Map<String, Object>> rawGroups) {
        if (rawGroups == null) {
            throw new IllegalStateException("No groups found in configuration");
        }

        return rawGroups.stream()
                .map(this::parseGroupConfiguration)
                .toList();
    }

    /**
     * Parses a single group configuration
     */
    @SuppressWarnings("unchecked")
    private GroupConfiguration parseGroupConfiguration(Map<String, Object> groupMap) {
        GroupConfiguration group = new GroupConfiguration();
        group.setId((String) groupMap.get("id"));
        group.setGroupName((String) groupMap.get("groupName"));
        group.setTitle((String) groupMap.get("title"));
        group.setDescription((String) groupMap.get("description"));
        group.setInterfaces((List<String>) groupMap.get("interfaces"));

        String serverUrl = (String) groupMap.get("serverUrl");
        if (serverUrl != null) {
            group.setServerUrl(serverUrl);
        }

        Map<String, Object> extensions = (Map<String, Object>) groupMap.get("extensions");
        if (extensions != null) {
            group.setExtensions(extensions);
        }

        return group;
    }

    /**
     * Gets the groups configuration
     */
    public List<GroupConfiguration> getGroups() {
        return groups;
    }

    /**
     * Gets the common configuration
     */
    public CommonConfiguration getCommonConfiguration() {
        return commonConfig;
    }
}