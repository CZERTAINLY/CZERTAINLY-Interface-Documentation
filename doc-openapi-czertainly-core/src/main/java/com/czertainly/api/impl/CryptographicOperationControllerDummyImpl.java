package com.czertainly.api.impl;

import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.interfaces.core.web.CryptographicOperationsController;
import com.czertainly.api.model.client.cryptography.operations.CipherDataRequestDto;
import com.czertainly.api.model.client.cryptography.operations.RandomDataRequestDto;
import com.czertainly.api.model.client.cryptography.operations.SignDataRequestDto;
import com.czertainly.api.model.client.cryptography.operations.VerifyDataRequestDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.cryptography.enums.CryptographicAlgorithm;
import com.czertainly.api.model.connector.cryptography.operations.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CryptographicOperationControllerDummyImpl implements CryptographicOperationsController {

    @Override
    public List<BaseAttribute> listCipherAttributes(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, CryptographicAlgorithm algorithm) throws ConnectorException {
        return null;
    }

    @Override
    public EncryptDataResponseDto encryptData(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, CipherDataRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public DecryptDataResponseDto decryptData(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, CipherDataRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public List<BaseAttribute> listSignatureAttributes(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, CryptographicAlgorithm algorithm) throws ConnectorException {
        return null;
    }

    @Override
    public SignDataResponseDto signData(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, SignDataRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public VerifyDataResponseDto verifyData(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, VerifyDataRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public List<BaseAttribute> listRandomAttributes(String tokenInstanceUuid) throws ConnectorException {
        return null;
    }

    @Override
    public RandomDataResponseDto randomData(String tokenInstanceUuid, RandomDataRequestDto request) throws ConnectorException {
        return null;
    }
}
