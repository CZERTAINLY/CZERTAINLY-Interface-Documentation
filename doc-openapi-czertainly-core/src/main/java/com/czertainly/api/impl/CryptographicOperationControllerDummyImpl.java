package com.czertainly.api.impl;

import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.CryptographicOperationsController;
import com.czertainly.api.model.client.cryptography.operations.*;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.common.attribute.v3.BaseAttributeV3;
import com.czertainly.api.model.common.enums.cryptography.KeyAlgorithm;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class CryptographicOperationControllerDummyImpl implements CryptographicOperationsController {

    @Override
    public List<BaseAttributeV3<?>> listCipherAttributes(@Parameter(description = "Token Instance UUID") @PathVariable String tokenInstanceUuid, @Parameter(description = "Token Profile UUID") @PathVariable String tokenProfileUuid, @Parameter(description = "Key UUID") @PathVariable String uuid, @Parameter(description = "Key Item UUID") @PathVariable String keyItemUuid, @Parameter(description = "Cryptographic algorithm") @PathVariable KeyAlgorithm algorithm) throws ConnectorException, NotFoundException {
        return List.of();
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
    public List<BaseAttributeV3<?>> listSignatureAttributes(@Parameter(description = "Token Instance UUID") @PathVariable String tokenInstanceUuid, @Parameter(description = "Token Profile UUID") @PathVariable String tokenProfileUuid, @Parameter(description = "Key instance UUID") @PathVariable String uuid, @Parameter(description = "Key Item UUID") @PathVariable String keyItemUuid, @Parameter(description = "Cryptographic algorithm") @PathVariable KeyAlgorithm algorithm) throws ConnectorException, NotFoundException {
        return List.of();
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
    public List<BaseAttribute> listRandomAttributes(@Parameter(description = "Token Instance UUID") @PathVariable String tokenInstanceUuid) throws ConnectorException, NotFoundException {
        return List.of();
    }


    @Override
    public RandomDataResponseDto randomData(String tokenInstanceUuid, RandomDataRequestDto request) throws ConnectorException {
        return null;
    }
}
