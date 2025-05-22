package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.ResourceController;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.other.ResourceDto;
import com.czertainly.api.model.core.other.ResourceEvent;
import com.czertainly.api.model.core.other.ResourceEventDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ResourceControllerDummyImpl implements ResourceController {

    @Override
    public List<ResourceDto> listResources() {
        return List.of();
    }

    @Override
    public List<SearchFieldDataByGroupDto> listResourceRuleFilterFields(Resource resource, boolean settable) {
        return List.of();
    }

    @Override
    public List<ResourceEventDto> listResourceEvents(Resource resource) {
        return List.of();
    }

    @Override
    public Map<ResourceEvent, List<ResourceEventDto>> listAllResourceEvents() {
        return Map.of();
    }
}
