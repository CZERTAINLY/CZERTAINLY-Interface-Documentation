package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.AuthorityInstanceController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.connector.authority.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorityInstanceControllerDummyImpl implements AuthorityInstanceController {


    @Override
    public List<AuthorityProviderInstanceDto> listAuthorityInstances() {
        return List.of();
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
    public List<BaseAttribute> listRAProfileAttributes(String uuid) throws NotFoundException {
        return List.of();
    }

    @Override
    public void validateRAProfileAttributes(String uuid, List<RequestAttribute> attributes) throws ValidationException, NotFoundException {

    }

    @Override
    public CertificateRevocationListResponseDto getCrl(String uuid, CertificateRevocationListRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public CaCertificatesResponseDto getCaCertificates(String uuid, CaCertificatesRequestDto raProfileAttributes) throws ValidationException, NotFoundException {
        return null;
    }
}
