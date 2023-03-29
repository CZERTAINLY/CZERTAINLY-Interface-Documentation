package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.AcmeProfileController;
import com.czertainly.api.interfaces.core.web.ScepProfileController;
import com.czertainly.api.model.client.acme.AcmeProfileEditRequestDto;
import com.czertainly.api.model.client.acme.AcmeProfileRequestDto;
import com.czertainly.api.model.client.scep.ScepProfileEditRequestDto;
import com.czertainly.api.model.client.scep.ScepProfileRequestDto;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.common.UuidDto;
import com.czertainly.api.model.core.acme.AcmeProfileDto;
import com.czertainly.api.model.core.acme.AcmeProfileListDto;
import com.czertainly.api.model.core.scep.ScepProfileDetailDto;
import com.czertainly.api.model.core.scep.ScepProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public List<BulkActionMessageDto> forceDeleteScepProfiles(List<String> uuids) throws NotFoundException, ValidationException {
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
}
