package com.czertainly.openapi.config.model;

import com.czertainly.openapi.config.util.ClassNameResolver;

import java.util.List;

/**
 * Model class representing a single group configuration from groups.yaml
 */
public class GroupConfiguration {
    private String id;
    private String groupName;
    private String title;
    private String description;
    private List<String> interfaces;
    private String serverUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<String> interfaces) {
        this.interfaces = interfaces;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    /**
     * Extracts controller implementation class names from the interface FQNs.
     * Uses ClassNameResolver to generate unique, collision-free class names.
     */
    public List<String> getControllerClassNames() {
        return interfaces.stream()
                .map(ClassNameResolver::generateImplementationClassName)
                .toList();
    }
}
