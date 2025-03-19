package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.ScepProfileController;
import com.czertainly.api.model.client.scep.ScepProfileEditRequestDto;
import com.czertainly.api.model.client.scep.ScepProfileRequestDto;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.core.certificate.CertificateDto;
import com.czertainly.api.model.core.scep.ScepProfileDetailDto;
import com.czertainly.api.model.core.scep.ScepProfileDto;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("java:S1186")
@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ScepProfileControllerDummyImpl implements ScepProfileController {

    @Override
    public List<ScepProfileDto> listScepProfiles() {
        return null;
    }

    @Override
    public ScepProfileDetailDto getScepProfile(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ScepProfileDetailDto> createScepProfile(ScepProfileRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException {
        return null;
    }

    @Override
    public ScepProfileDetailDto editScepProfile(String uuid, ScepProfileEditRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deleteScepProfile(String uuid) throws NotFoundException, ValidationException {

    }

    @Override
    public List<BulkActionMessageDto> bulkDeleteScepProfile(List<String> uuids) {
        return null;
    }

    @Override
    public List<BulkActionMessageDto> forceDeleteScepProfiles(List<String> uuids) throws ValidationException {
        return null;
    }

    @Override
    public void enableScepProfile(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkEnableScepProfile(List<String> uuids) {

    }

    @Override
    public void disableScepProfile(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkDisableScepProfile(List<String> uuids) {

    }

    @Override
    public void updateRaProfile(String uuid, String raProfileUuid) throws NotFoundException {

    }

    @Override
    public List<CertificateDto> listScepCaCertificates(boolean intuneEnabled) {
        return null;
    }
}
