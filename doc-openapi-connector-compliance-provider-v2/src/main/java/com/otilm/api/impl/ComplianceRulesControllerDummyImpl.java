package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.v2.ComplianceRuleController;
import com.czertainly.api.model.connector.compliance.v2.ComplianceGroupResponseDto;
import com.czertainly.api.model.connector.compliance.v2.ComplianceRuleResponseDto;
import com.czertainly.api.model.connector.compliance.v2.ComplianceRulesBatchRequestDto;
import com.czertainly.api.model.connector.compliance.v2.ComplianceRulesBatchResponseDto;
import com.czertainly.api.model.core.auth.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class ComplianceRulesControllerDummyImpl implements ComplianceRuleController {

    @Override
    public List<ComplianceRuleResponseDto> getRules(String kind, Resource resource, String type, String format) throws IOException, NotFoundException {
        return List.of();
    }

    @Override
    public ComplianceRulesBatchResponseDto getRulesBatch(String kind, ComplianceRulesBatchRequestDto request) throws IOException, NotFoundException {
        return null;
    }

    @Override
    public ComplianceRuleResponseDto getRule(String kind, UUID ruleUuid) throws IOException, NotFoundException {
        return null;
    }

    @Override
    public List<ComplianceGroupResponseDto> getGroups(String kind, Resource resource) throws IOException, NotFoundException {
        return List.of();
    }

    @Override
    public ComplianceGroupResponseDto getGroup(String kind, UUID groupUuid) throws IOException, NotFoundException {
        return null;
    }

    @Override
    public List<ComplianceRuleResponseDto> getGroupRules(String kind, UUID groupUuid) throws IOException, NotFoundException {
        return List.of();
    }
}
