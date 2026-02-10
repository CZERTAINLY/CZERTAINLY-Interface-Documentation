package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.ComplianceRulesController;
import com.czertainly.api.model.connector.compliance.ComplianceGroupsResponseDto;
import com.czertainly.api.model.connector.compliance.ComplianceRulesResponseDto;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ComplianceRulesControllerDummyImpl implements ComplianceRulesController {

    @Override
    public List<ComplianceRulesResponseDto> getRules(String kind) throws IOException, NotFoundException {
        return null;
    }

    @Override
    public List<ComplianceGroupsResponseDto> getGroups(String kind) throws IOException, NotFoundException {
        return null;
    }

    @Override
    public List<ComplianceRulesResponseDto> getGroupRules(String kind, String uuid) throws IOException, NotFoundException {
        return null;
    }
}
