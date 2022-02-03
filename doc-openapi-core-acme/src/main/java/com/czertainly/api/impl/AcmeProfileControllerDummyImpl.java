package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.AcmeProfileController;
import com.czertainly.api.model.client.acme.AcmeProfileEditRequestDto;
import com.czertainly.api.model.client.acme.AcmeProfileRequestDto;
import com.czertainly.api.model.client.connector.ForceDeleteMessageDto;
import com.czertainly.api.model.common.UuidDto;
import com.czertainly.api.model.core.acme.AcmeProfileDto;
import com.czertainly.api.model.core.acme.AcmeProfileListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcmeProfileControllerDummyImpl implements AcmeProfileController {

    @Override
    public List<AcmeProfileListDto> listAcmeProfile() {
        return null;
    }

    @Override
    public AcmeProfileDto getAcmeProfile(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<UuidDto> createAcmeProfile(AcmeProfileRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException {
        return null;
    }

    @Override
    public AcmeProfileDto updateAcmeProfile(String uuid, AcmeProfileEditRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public List<ForceDeleteMessageDto> deleteAcmeProfile(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void enableAcmeProfile(String uuid) throws NotFoundException {

    }

    @Override
    public void disableAcmeProfile(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkEnableAcmeProfile(List<String> uuids) {

    }

    @Override
    public void bulkDisableAcmeProfile(List<String> uuids) {

    }

    @Override
    public List<ForceDeleteMessageDto> bulkDeleteAcmeProfile(List<String> uuids) {
        return null;
    }

    @Override
    public void bulkForceRemoveACMEProfiles(List<String> uuids) throws NotFoundException, ValidationException {

    }

    @Override
    public void updateRaProfile(String uuid, String raProfileUuid) throws NotFoundException {

    }

}