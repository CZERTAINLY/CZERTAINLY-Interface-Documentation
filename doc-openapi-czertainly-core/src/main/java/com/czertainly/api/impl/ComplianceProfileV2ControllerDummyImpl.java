package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.AttributeException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.v2.ComplianceProfileController;
import com.czertainly.api.model.client.compliance.v2.*;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.compliance.v2.ComplianceGroupListDto;
import com.czertainly.api.model.core.compliance.v2.ComplianceProfileDto;
import com.czertainly.api.model.core.compliance.v2.ComplianceProfileListDto;
import com.czertainly.api.model.core.compliance.v2.ComplianceRuleListDto;
import com.czertainly.api.model.core.other.ResourceObjectDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ComplianceProfileV2ControllerDummyImpl implements ComplianceProfileController {

    @Override
    public List<ComplianceProfileListDto> listComplianceProfiles() {
        return List.of();
    }

    @Override
    public ComplianceProfileDto getComplianceProfile(UUID uuid) throws ConnectorException, NotFoundException {
        return null;
    }

    @Override
    public ComplianceProfileDto createComplianceProfile(ComplianceProfileRequestDto request) throws ConnectorException, NotFoundException, AlreadyExistException, AttributeException {
        return null;
    }

    @Override
    public ComplianceProfileDto updateComplianceProfile(UUID uuid, ComplianceProfileUpdateRequestDto request) throws ConnectorException, NotFoundException, AttributeException {
        return null;
    }

    @Override
    public void deleteComplianceProfile(UUID uuid) throws NotFoundException {

    }

    @Override
    public List<BulkActionMessageDto> bulkDeleteComplianceProfiles(List<UUID> uuids) {
        return List.of();
    }

    @Override
    public List<BulkActionMessageDto> forceDeleteComplianceProfiles(List<UUID> uuids) {
        return List.of();
    }

    @Override
    public List<ComplianceRuleListDto> getComplianceRules(UUID connectorUuid, String kind, Resource resource, String type, String format) throws ConnectorException, NotFoundException {
        return List.of();
    }

    @Override
    public List<ComplianceGroupListDto> getComplianceGroups(UUID connectorUuid, String kind, Resource resource) throws ConnectorException, NotFoundException {
        return List.of();
    }

    @Override
    public List<ComplianceRuleListDto> getComplianceGroupRules(UUID groupUuid, UUID connectorUuid, String kind) throws ConnectorException, NotFoundException {
        return List.of();
    }

    @Override
    public ComplianceRuleListDto createComplianceInternalRule(ComplianceInternalRuleRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public ComplianceRuleListDto updateComplianceInternalRule(UUID internalRuleUuid, ComplianceInternalRuleRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteComplianceInternalRule(UUID internalRuleUuid) throws NotFoundException {

    }

    @Override
    public void patchComplianceProfileRule(UUID uuid, ComplianceProfileRulesPatchRequestDto request) throws ConnectorException, NotFoundException {

    }

    @Override
    public void patchComplianceProfileGroup(UUID uuid, ComplianceProfileGroupsPatchRequestDto request) throws ConnectorException, NotFoundException {

    }

    @Override
    public List<ResourceObjectDto> getAssociations(UUID uuid) throws NotFoundException {
        return List.of();
    }

    @Override
    public void associateComplianceProfile(UUID uuid, Resource resource, UUID associationObjectUuid) throws NotFoundException {

    }

    @Override
    public void disassociateComplianceProfile(UUID uuid, Resource resource, UUID associationObjectUuid) throws NotFoundException {

    }

    @Override
    public List<ComplianceProfileListDto> getAssociatedComplianceProfiles(Resource resource, UUID associationObjectUuid) {
        return List.of();
    }
}
