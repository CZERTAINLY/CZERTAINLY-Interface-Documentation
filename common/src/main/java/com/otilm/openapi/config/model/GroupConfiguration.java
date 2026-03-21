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
            if (interfaces.contains(null)) {
                throw new IllegalArgumentException(
                        "Interfaces list contains null elements for group '" + (id != null ? id : "<unknown>") + "'"
                );
            }
            this.interfaces = List.copyOf(interfaces);
        }
    }

    public void setExtensions(Map<String, Object> extensions) {
        if (extensions != null) {
            if (extensions.containsKey(null) || extensions.containsValue(null)) {
                throw new IllegalArgumentException(
                        "Extensions map contains null keys or values for group '" + (id != null ? id : "<unknown>") + "'"
                );
            }
            this.extensions = Map.copyOf(extensions);
        }
    }
}
