package com.otilm.openapi.config.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Unified model for the entire groups.yaml configuration
 */
public class GroupsConfig {
    private CommonConfiguration common = new CommonConfiguration();
    private List<GroupConfiguration> groups = Collections.emptyList();
    private SecurityConfiguration security = new SecurityConfiguration(Collections.emptyList(), Collections.emptyList());

    public CommonConfiguration getCommon() {
        return common;
    }

    public void setCommon(CommonConfiguration common) {
        if (common != null) {
            this.common = common;
        }
    }

    public List<GroupConfiguration> getGroups() {
        return Collections.unmodifiableList(groups);
    }

    public void setGroups(List<GroupConfiguration> groups) {
        if (groups != null) {
            this.groups = Collections.unmodifiableList(groups);
        }
    }

    public SecurityConfiguration getSecurity() {
        return security;
    }

    public void setSecurity(SecurityConfiguration security) {
        if (security != null) {
            this.security = security;
        }
    }
}
