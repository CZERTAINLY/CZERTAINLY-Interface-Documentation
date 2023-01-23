package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.cryptography.CryptographicOperationsController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.cryptography.operations.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CryptographicOperationControllerDummyImpl implements CryptographicOperationsController {


    @Override
    public EncryptDataResponseDto encryptData(String uuid, String keyUuid, CipherDataRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public DecryptDataResponseDto decryptData(String uuid, String keyUuid, CipherDataRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public SignDataResponseDto signData(String uuid, String keyUuid, SignDataRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public VerifyDataResponseDto verifyData(String uuid, String keyUuid, VerifyDataRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public List<BaseAttribute> listRandomAttributes(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validateRandomAttributes(String uuid, List<RequestAttributeDto> attributes) throws NotFoundException, ValidationException {

    }

    @Override
    public RandomDataResponseDto randomData(String uuid, RandomDataRequestDto request) throws NotFoundException {
        return null;
    }
}
