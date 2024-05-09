package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.ResourceController;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.other.ResourceDto;
import com.czertainly.api.model.core.other.ResourceEvent;
import com.czertainly.api.model.core.other.ResourceEventDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceControllerDummyImpl implements ResourceController {

    @Override
    public List<ResourceDto> listResources() {
        return List.of();
    }

    @Override
    public List<SearchFieldDataByGroupDto> listResourceRuleFilterFields(Resource resource, boolean settable) throws NotFoundException {
        return List.of();
    }

    @Override
    public List<ResourceEventDto> listResourceEvents(Resource resource) {
        return List.of();
    }
}
