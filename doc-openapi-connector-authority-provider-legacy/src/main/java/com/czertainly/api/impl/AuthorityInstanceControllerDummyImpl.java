package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.AuthorityInstanceController;
import com.czertainly.api.model.common.AttributeDefinition;
import com.czertainly.api.model.common.RequestAttributeDto;
import com.czertainly.api.model.connector.authority.AuthorityProviderInstanceDto;
import com.czertainly.api.model.connector.authority.AuthorityProviderInstanceRequestDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorityInstanceControllerDummyImpl implements AuthorityInstanceController {

    @Override
    public List<AuthorityProviderInstanceDto> listAuthorityInstances() {
        return null;
    }

    @Override
    public AuthorityProviderInstanceDto getAuthorityInstance(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public AuthorityProviderInstanceDto createAuthorityInstance(AuthorityProviderInstanceRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public AuthorityProviderInstanceDto updateAuthorityInstance(String uuid, AuthorityProviderInstanceRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void removeAuthorityInstance(String uuid) throws NotFoundException {

    }

    @Override
    public void getConnection(String uuid) throws NotFoundException {

    }

    @Override
    public List<AttributeDefinition> listRAProfileAttributes(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public boolean validateRAProfileAttributes(String uuid, List<RequestAttributeDto> attributes) throws ValidationException, NotFoundException {
        return false;
    }

}
