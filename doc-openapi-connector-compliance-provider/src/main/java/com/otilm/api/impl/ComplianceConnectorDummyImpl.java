package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.ComplianceController;
import com.czertainly.api.model.connector.compliance.ComplianceRequestDto;
import com.czertainly.api.model.connector.compliance.ComplianceResponseDto;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ComplianceConnectorDummyImpl implements ComplianceController {

    @Override
    public ComplianceResponseDto checkCompliance(String kind, ComplianceRequestDto request) throws IOException, NotFoundException {
        return null;
    }
}
