package com.otilm.api.impl;

import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.interfaces.core.web.CryptographicOperationsController;
import com.czertainly.api.model.client.cryptography.operations.*;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.common.enums.cryptography.KeyAlgorithm;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CryptographicOperationControllerDummyImpl implements CryptographicOperationsController {


    @Override
    public List<BaseAttribute> listCipherAttributes(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, KeyAlgorithm algorithm) throws ConnectorException {
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
    public List<BaseAttribute> listSignatureAttributes(String tokenInstanceUuid, String tokenProfileUuid, String uuid, String keyItemUuid, KeyAlgorithm algorithm) throws ConnectorException {
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
