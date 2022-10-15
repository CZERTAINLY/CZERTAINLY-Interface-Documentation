package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.RAProfileManagementController;
import com.czertainly.api.model.client.compliance.SimplifiedComplianceProfileDto;
import com.czertainly.api.model.client.raprofile.*;
import com.czertainly.api.model.common.attribute.AttributeDefinition;
import com.czertainly.api.model.core.raprofile.RaProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RAProfileManagementControllerDummyImpl implements RAProfileManagementController {
    @Override
    public List<RaProfileDto> listRaProfiles(Optional<Boolean> enabled) {
        return null;
    }

    @Override
    public ResponseEntity<?> createRaProfile(String authorityUuid, AddRaProfileRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException {
        return null;
    }

    @Override
    public RaProfileDto getRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RaProfileDto getRaProfile(String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RaProfileDto editRaProfile(String authorityUuid, String raProfileUuid, EditRaProfileRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deleteRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Override
    public void deleteRaProfile(String raProfileUuid) throws NotFoundException {

    }

    @Override
    public void disableRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Override
    public void enableRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Override
    public void bulkDeleteRaProfile(List<String> uuids) throws NotFoundException, ValidationException {

    }

    @Override
    public void bulkDisableRaProfile(List<String> uuids) throws NotFoundException {

    }

    @Override
    public void bulkEnableRaProfile(List<String> uuids) throws NotFoundException {

    }

    @Override
    public RaProfileAcmeDetailResponseDto getAcmeForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RaProfileAcmeDetailResponseDto activateAcmeForRaProfile(String authorityUuid, String raProfileUuid, String acmeProfileUuid, ActivateAcmeForRaProfileRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deactivateAcmeForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Override
    public List<AttributeDefinition> listRevokeCertificateAttributes(String authorityUuid, String raProfileUuid) throws ConnectorException {
        return null;
    }

    @Override
    public List<AttributeDefinition> listIssueCertificateAttributes(String authorityUuid, String raProfileUuid) throws ConnectorException {
        return null;
    }

    @Override
    public void checkCompliance(List<String> uuids) throws NotFoundException {

    }

    @Override
    public List<SimplifiedComplianceProfileDto> getAssociatedComplianceProfiles(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }
}
