package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.AuthorityInstanceController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.client.authority.AuthorityInstanceRequestDto;
import com.czertainly.api.model.client.authority.AuthorityInstanceUpdateRequestDto;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.common.NameAndIdDto;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.core.authority.AuthorityInstanceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorityInstanceControllerDummyImpl implements AuthorityInstanceController {

    @Override
    public List<AuthorityInstanceDto> listAuthorityInstances() {
        return null;
    }

    @Override
    public AuthorityInstanceDto getAuthorityInstance(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public ResponseEntity<?> createAuthorityInstance(AuthorityInstanceRequestDto request) throws AlreadyExistException, ConnectorException {
        return null;
    }

    @Override
    public AuthorityInstanceDto editAuthorityInstance(String uuid, AuthorityInstanceUpdateRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deleteAuthorityInstance(String uuid) throws ConnectorException {

    }

    @Override
    public List<NameAndIdDto> listEntityProfiles(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public List<NameAndIdDto> listCertificateProfiles(String uuid, Integer endEntityProfileId) throws ConnectorException {
        return null;
    }

    @Override
    public List<NameAndIdDto> listCAsInProfile(String uuid, Integer endEntityProfileId) throws ConnectorException {
        return null;
    }

    @Override
    public List<BaseAttribute> listRAProfileAttributes(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public void validateRAProfileAttributes(String uuid, List<RequestAttribute> attributes) throws ConnectorException, NotFoundException {

    }


    @Override
    public List<BulkActionMessageDto> bulkDeleteAuthorityInstance(List<String> uuids) throws ConnectorException, ValidationException {
        return null;
    }

    @Override
    public List<BulkActionMessageDto> forceDeleteAuthorityInstances(List<String> uuids) throws NotFoundException, ValidationException {
        return null;
    }
}
