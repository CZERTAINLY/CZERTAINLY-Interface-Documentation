package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.cryptography.TokenInstanceController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.connector.cryptography.token.TokenInstanceDto;
import com.czertainly.api.model.connector.cryptography.token.TokenInstanceRequestDto;
import com.czertainly.api.model.connector.cryptography.token.TokenInstanceStatusDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return List.of();
    }

    @Override
    public void validateTokenProfileAttributes(String uuid, List<RequestAttribute> attributes) throws ValidationException, NotFoundException {

    }


    @Override
    public List<BaseAttribute> listTokenInstanceActivationAttributes(String uuid) throws NotFoundException {
        return List.of();
    }


    @Override
    public void validateTokenInstanceActivationAttributes(String uuid, List<RequestAttribute> attributes) throws ValidationException, NotFoundException {

    }

    @Override
    public void activateTokenInstance(String uuid, List<RequestAttribute> attributes) throws NotFoundException {

    }


    @Override
    public void deactivateTokenInstance(String uuid) throws NotFoundException {

    }
}
