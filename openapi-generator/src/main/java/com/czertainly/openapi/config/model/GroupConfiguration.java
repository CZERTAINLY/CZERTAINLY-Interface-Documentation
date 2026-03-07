package com.czertainly.openapi.config.model;

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

    /**
     * Extracts controller implementation class names from the interface FQNs
     */
    public List<String> getControllerClassNames() {
        return interfaces.stream()
                .map(this::extractControllerClassName)
                .toList();
    }

    private String extractControllerClassName(String interfaceFqn) {
        String interfaceName = interfaceFqn.substring(interfaceFqn.lastIndexOf('.') + 1);
        return interfaceName + "DummyImpl";
    }
}
