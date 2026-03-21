package com.otilm.openapi.config.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Model class representing a single group configuration from groups.yaml
 */
@Getter
@Setter
public class GroupConfiguration {
    private String id;
    private String groupName;
    private String title;
    private String description;
    private List<String> interfaces = Collections.emptyList();
    private String serverUrl;
    private Map<String, Object> extensions = Collections.emptyMap();
    private String indexCategory;

    public void setInterfaces(List<String> interfaces) {
        if (interfaces != null) {
            this.interfaces = List.copyOf(interfaces);
        }
    }

    public void setExtensions(Map<String, Object> extensions) {
        if (extensions != null) {
            this.extensions = Map.copyOf(extensions);
        }
    }
}
