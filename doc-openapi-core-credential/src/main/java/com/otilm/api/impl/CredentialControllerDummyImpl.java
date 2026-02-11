package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.CredentialController;
import com.czertainly.api.model.client.credential.CredentialRequestDto;
import com.czertainly.api.model.client.credential.CredentialUpdateRequestDto;
import com.czertainly.api.model.core.credential.CredentialDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CredentialControllerDummyImpl implements CredentialController {
    @Override
    public List<CredentialDto> listCredentials() {
        return null;
    }

    @Override
    public CredentialDto getCredential(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<?> createCredential(CredentialRequestDto request) throws AlreadyExistException, NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public CredentialDto editCredential(String uuid, CredentialUpdateRequestDto request) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public void deleteCredential(String uuid) throws NotFoundException {

    }

    @Override
    public void enableCredential(String uuid) throws NotFoundException {

    }

    @Override
    public void disableCredential(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkDeleteCredential(List<String> uuids) throws NotFoundException, ValidationException {

    }
}
