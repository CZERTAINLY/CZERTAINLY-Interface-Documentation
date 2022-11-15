package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.client.ClientOperationController;
import com.czertainly.api.model.client.authority.*;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

@RestController
public class ClientOperationLegacyControllerDummyImpl implements ClientOperationController {
    @Override
    public ClientCertificateSignResponseDto issueCertificate(String raProfileName, ClientCertificateSignRequestDto request) throws NotFoundException, CertificateException, AlreadyExistException, ConnectorException, NoSuchAlgorithmException {
        return null;
    }

    @Override
    public void revokeCertificate(String raProfileName, ClientCertificateRevocationDto request) throws NotFoundException, ConnectorException {

    }

    @Override
    public List<ClientEndEntityDto> listEntities(String raProfileName) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public void addEndEntity(String raProfileName, ClientAddEndEntityRequestDto request) throws NotFoundException, AlreadyExistException, ConnectorException {

    }

    @Override
    public ClientEndEntityDto getEndEntity(String raProfileName, String username) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public void editEndEntity(String raProfileName, String username, ClientEditEndEntityRequestDto request) throws NotFoundException, ConnectorException {

    }

    @Override
    public void revokeAndDeleteEndEntity(String raProfileName, String username) throws NotFoundException, ConnectorException {

    }

    @Override
    public void resetPassword(String raProfileName, String username) throws NotFoundException, ConnectorException {

    }
}
