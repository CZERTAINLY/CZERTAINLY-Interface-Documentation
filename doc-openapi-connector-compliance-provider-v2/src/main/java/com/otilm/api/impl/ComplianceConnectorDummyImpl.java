package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.v2.ComplianceController;
import com.czertainly.api.model.connector.compliance.v2.ComplianceRequestDto;
import com.czertainly.api.model.connector.compliance.v2.ComplianceResponseDto;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ComplianceConnectorDummyImpl implements ComplianceController {

    @Override
    public ComplianceResponseDto checkCompliance(String kind, ComplianceRequestDto request) throws IOException, NotFoundException {
        return null;
    }
}
