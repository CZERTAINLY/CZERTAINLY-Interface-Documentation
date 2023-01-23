package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.cryptography.TokenInstanceController;
import com.czertainly.api.interfaces.connector.entity.EntityController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.cryptography.token.TokenInstanceDto;
import com.czertainly.api.model.connector.cryptography.token.TokenInstanceRequestDto;
import com.czertainly.api.model.connector.cryptography.token.TokenInstanceStatusDto;
import com.czertainly.api.model.connector.entity.EntityInstanceDto;
import com.czertainly.api.model.connector.entity.EntityInstanceRequestDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TokenInstanceControllerDummyImpl implements TokenInstanceController {


    @Override
    public List<TokenInstanceDto> listTokenInstances() {
        return null;
    }

    @Override
    public TokenInstanceDto getTokenInstance(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public TokenInstanceDto createTokenInstance(TokenInstanceRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public TokenInstanceDto updateTokenInstance(String uuid, TokenInstanceRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void removeTokenInstance(String uuid) throws NotFoundException {

    }

    @Override
    public TokenInstanceStatusDto getTokenInstanceStatus(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public List<BaseAttribute> listTokenProfileAttributes(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validateTokenProfileAttributes(String uuid, List<RequestAttributeDto> attributes) throws ValidationException, NotFoundException {

    }

    @Override
    public List<BaseAttribute> listTokenInstanceActivationAttributes(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validateTokenInstanceActivationAttributes(String uuid, List<RequestAttributeDto> attributes) throws ValidationException, NotFoundException {

    }

    @Override
    public void activateTokenInstance(String uuid, List<RequestAttributeDto> attributes) throws NotFoundException {

    }

    @Override
    public void deactivateTokenInstance(String uuid) throws NotFoundException {

    }
}
