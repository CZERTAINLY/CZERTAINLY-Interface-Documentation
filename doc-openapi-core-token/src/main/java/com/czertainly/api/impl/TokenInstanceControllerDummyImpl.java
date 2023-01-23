package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.TokenInstanceController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.client.cryptography.token.TokenInstanceRequestDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.cryptography.token.TokenInstanceDetailDto;
import com.czertainly.api.model.core.cryptography.token.TokenInstanceDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TokenInstanceControllerDummyImpl implements TokenInstanceController {

    @Override
    public List<TokenInstanceDto> listTokenInstances() {
        return null;
    }

    @Override
    public TokenInstanceDetailDto getTokenInstance(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public TokenInstanceDetailDto createTokenInstance(TokenInstanceRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException {
        return null;
    }

    @Override
    public TokenInstanceDetailDto updateTokenInstance(String uuid, TokenInstanceRequestDto request) throws ConnectorException, ValidationException {
        return null;
    }

    @Override
    public void deleteTokenInstance(String uuid) throws NotFoundException {

    }

    @Override
    public void activateTokenInstance(String uuid, List<RequestAttributeDto> attributes) throws ConnectorException {

    }

    @Override
    public void deactivateTokenInstance(String uuid) throws ConnectorException {

    }

    @Override
    public void deleteTokenInstance(List<String> uuids) {

    }

    @Override
    public TokenInstanceDetailDto reloadStatus(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public List<BaseAttribute> listTokenProfileAttributes(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public List<BaseAttribute> listTokenInstanceActivationAttributes(String uuid) throws ConnectorException {
        return null;
    }
}
