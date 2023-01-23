package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.cryptography.KeyManagementController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.cryptography.key.CreateKeyRequestDto;
import com.czertainly.api.model.connector.cryptography.key.KeyDataResponseDto;
import com.czertainly.api.model.connector.cryptography.key.KeyPairDataResponseDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KeyManagementControllerDummyImpl implements KeyManagementController {

    @Override
    public List<BaseAttribute> listCreateSecretKeyAttributes(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validateCreateSecretKeyAttributes(String uuid, List<RequestAttributeDto> attributes) throws NotFoundException, ValidationException {

    }

    @Override
    public KeyDataResponseDto createSecretKey(String uuid, CreateKeyRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public List<BaseAttribute> listCreateKeyPairAttributes(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validateCreateKeyPairAttributes(String uuid, List<RequestAttributeDto> attributes) throws NotFoundException, ValidationException {

    }

    @Override
    public KeyPairDataResponseDto createKeyPair(String uuid, CreateKeyRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public List<KeyDataResponseDto> listKeys(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public KeyDataResponseDto getKey(String uuid, String keyUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void destroyKey(String uuid, String keyUuid) throws NotFoundException {

    }
}
