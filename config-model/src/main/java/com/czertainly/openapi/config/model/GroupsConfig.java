package com.czertainly.openapi.config.model;

import java.util.List;

/**
 * Unified model for the entire groups.yaml configuration
 */
public class GroupsConfig {
    private CommonConfiguration common;
    private List<GroupConfiguration> groups;
    private SecurityConfiguration security;

    public CommonConfiguration getCommon() {
        return common;
    }

    public void setCommon(CommonConfiguration common) {
        this.common = common;
    }

    public List<GroupConfiguration> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupConfiguration> groups) {
        this.groups = groups;
    }

    public SecurityConfiguration getSecurity() {
        return security;
    }

    public void setSecurity(SecurityConfiguration security) {
        this.security = security;
    }
}
