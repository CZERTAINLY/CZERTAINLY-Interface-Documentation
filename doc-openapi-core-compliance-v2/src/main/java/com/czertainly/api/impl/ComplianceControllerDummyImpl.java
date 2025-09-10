package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.v2.ComplianceController;
import com.czertainly.api.model.core.auth.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ComplianceControllerDummyImpl implements ComplianceController {

    @Override
    public void checkCompliance(List<UUID> uuids, Resource resource, String type) {

    }

    @Override
    public void checkResourceObjectsCompliance(Resource resource, List<UUID> objectUuids) {

    }
}
