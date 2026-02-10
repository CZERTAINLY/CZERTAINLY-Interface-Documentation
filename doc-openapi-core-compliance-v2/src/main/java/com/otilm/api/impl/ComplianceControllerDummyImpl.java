package com.otilm.api.impl;

import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.v2.ComplianceController;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.compliance.v2.ComplianceCheckResultDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@SuppressWarnings("java:S1186")
public class ComplianceControllerDummyImpl implements ComplianceController {

    @Override
    public void checkCompliance(List<UUID> uuids, Resource resource, String type) throws ConnectorException, NotFoundException {

    }

    @Override
    public void checkResourceObjectsCompliance(Resource resource, List<UUID> objectUuids) throws ConnectorException, NotFoundException {

    }

    @Override
    public void checkResourceObjectCompliance(Resource resource, UUID objectUuid) throws ConnectorException, NotFoundException {

    }

    @Override
    public ComplianceCheckResultDto getComplianceCheckResult(Resource resource, UUID objectUuid) throws NotFoundException {
        return null;
    }
}
