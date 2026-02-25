package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.secrets.SecretController;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.connector.secrets.*;
import com.czertainly.api.model.connector.secrets.content.SecretContent;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecretControllerDummyImpl implements SecretController {

    @Override
    public List<BaseAttribute> getSecretAttributes(SecretType secretType) {
        return List.of();
    }

    @Override
    public SecretContentResponseDto getSecretContent(SecretRequestDto request, String version) throws NotFoundException {
        return null;
    }

    @Override
    public SecretResponseDto createSecret(CreateSecretRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public SecretResponseDto updateSecret(UpdateSecretRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteSecret(SecretRequestDto request) throws NotFoundException {

    }

    @Override
    public List<BaseAttribute> getRotateAttributes() throws NotFoundException {
        return List.of();
    }

    @Override
    public SecretResponseDto rotateSecret(SecretRequestDto request) throws NotFoundException {
        return null;
    }
}
