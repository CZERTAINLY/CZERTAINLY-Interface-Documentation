package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.TokenProfileController;
import com.czertainly.api.model.client.cryptography.tokenprofile.AddTokenProfileRequestDto;
import com.czertainly.api.model.client.cryptography.tokenprofile.BulkTokenProfileKeyUsageRequestDto;
import com.czertainly.api.model.client.cryptography.tokenprofile.EditTokenProfileRequestDto;
import com.czertainly.api.model.client.cryptography.tokenprofile.TokenProfileKeyUsageRequestDto;
import com.czertainly.api.model.core.cryptography.tokenprofile.TokenProfileDetailDto;
import com.czertainly.api.model.core.cryptography.tokenprofile.TokenProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TokenProfileManagementControllerDummyImpl implements TokenProfileController {
    @Override
    public List<TokenProfileDto> listTokenProfiles(Optional<Boolean> enabled) {
        return null;
    }

    @Override
    public TokenProfileDetailDto getTokenProfile(String tokenInstanceUuid, String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<TokenProfileDetailDto> createTokenProfile(String tokenInstanceUuid, AddTokenProfileRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException {
        return null;
    }

    @Override
    public TokenProfileDetailDto editTokenProfile(String tokenInstanceUuid, String uuid, EditTokenProfileRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deleteTokenProfile(String tokenInstanceUuid, String uuid) throws NotFoundException {

    }

    @Override
    public void deleteTokenProfile(String uuid) throws NotFoundException {

    }

    @Override
    public void disableTokenProfile(String tokenInstanceUuid, String uuid) throws NotFoundException {

    }

    @Override
    public void enableTokenProfile(String tokenInstanceUuid, String uuid) throws NotFoundException {

    }

    @Override
    public void deleteTokenProfiles(List<String> uuids) {

    }

    @Override
    public void disableTokenProfiles(List<String> uuids) {

    }

    @Override
    public void enableTokenProfiles(List<String> uuids) {

    }

    @Override
    public void updateKeyUsages(String tokenInstanceUuid, String tokenProfileUuid, TokenProfileKeyUsageRequestDto request) throws NotFoundException, ValidationException {

    }

    @Override
    public void updateKeysUsages(BulkTokenProfileKeyUsageRequestDto request) {

    }
}
