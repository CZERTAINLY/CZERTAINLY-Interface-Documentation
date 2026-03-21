package com.otilm.openapi.config.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Model class representing a single group configuration from groups.yaml
 */
public class GroupConfiguration {
    private String id;
    private String groupName;
    private String title;
    private String description;
    private List<String> interfaces = Collections.emptyList();
    private String serverUrl;
    private Map<String, Object> extensions = Collections.emptyMap();
    private String indexCategory;

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
        if (interfaces != null) {
            this.interfaces = Collections.unmodifiableList(interfaces);
        }
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public Map<String, Object> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, Object> extensions) {
        if (extensions != null) {
            this.extensions = Collections.unmodifiableMap(extensions);
        }
    }

    /**
     * Optional category for the API index page (e.g. "core", "connector", "protocol").
     * Groups without this field are not listed in the generated index.
     */
    public String getIndexCategory() {
        return indexCategory;
    }

    public void setIndexCategory(String indexCategory) {
        this.indexCategory = indexCategory;
    }
}
