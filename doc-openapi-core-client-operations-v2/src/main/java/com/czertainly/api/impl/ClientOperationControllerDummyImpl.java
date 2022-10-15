package com.czertainly.api.impl;

import com.czertainly.api.exception.*;
import com.czertainly.api.interfaces.core.client.v2.ClientOperationController;
import com.czertainly.api.model.common.attribute.AttributeDefinition;
import com.czertainly.api.model.common.attribute.RequestAttributeDto;
import com.czertainly.api.model.core.v2.ClientCertificateDataResponseDto;
import com.czertainly.api.model.core.v2.ClientCertificateRenewRequestDto;
import com.czertainly.api.model.core.v2.ClientCertificateRevocationDto;
import com.czertainly.api.model.core.v2.ClientCertificateSignRequestDto;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

@RestController
public class ClientOperationControllerDummyImpl implements ClientOperationController {
    @Override
    public List<AttributeDefinition> listIssueCertificateAttributes(String authorityUuid, String raProfileUuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public void validateIssueCertificateAttributes(String authorityUuid, String raProfileUuid, List<RequestAttributeDto> attributes) throws NotFoundException, ConnectorException, ValidationException {

    }

    @Override
    public ClientCertificateDataResponseDto issueCertificate(String authorityUuid, String raProfileUuid, ClientCertificateSignRequestDto request) throws NotFoundException, ConnectorException, AlreadyExistException, CertificateException, NoSuchAlgorithmException {
        return null;
    }

    @Override
    public ClientCertificateDataResponseDto renewCertificate(String authorityUuid, String raProfileUuid, String certificateUuid, ClientCertificateRenewRequestDto request) throws NotFoundException, ConnectorException, AlreadyExistException, CertificateException, CertificateOperationException {
        return null;
    }

    @Override
    public List<AttributeDefinition> listRevokeCertificateAttributes(String authorityUuid, String raProfileUuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public void validateRevokeCertificateAttributes(String authorityUuid, String raProfileUuid, List<RequestAttributeDto> attributes) throws NotFoundException, ConnectorException, ValidationException {

    }

    @Override
    public void revokeCertificate(String authorityUuid, String raProfileUuid, String certificateUuid, ClientCertificateRevocationDto request) throws NotFoundException, ConnectorException {

    }
}
