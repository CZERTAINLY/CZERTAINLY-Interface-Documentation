package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.client.v2.ClientOperationController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.v2.*;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

@RestController
public class ClientOperationControllerDummyImpl implements ClientOperationController {

    @Hidden
    @Override
    public List<BaseAttribute> listIssueCertificateAttributes(String authorityUuid, String raProfileUuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Hidden
    @Override
    public void validateIssueCertificateAttributes(String authorityUuid, String raProfileUuid, List<RequestAttributeDto> attributes) throws NotFoundException, ConnectorException, ValidationException {

    }

    @Hidden
    @Override
    public ClientCertificateDataResponseDto issueRequestedCertificate(String authorityUuid, String raProfileUuid, String certificateUuid) throws NotFoundException, ConnectorException, AlreadyExistException, CertificateException, NoSuchAlgorithmException {
        return null;
    }

    @Override
    public ClientCertificateDataResponseDto issueCertificate(String authorityUuid, String raProfileUuid, ClientCertificateSignRequestDto request) throws NotFoundException, CertificateException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        return null;
    }

    @Hidden
    @Override
    public ClientCertificateDataResponseDto renewCertificate(String authorityUuid, String raProfileUuid, String certificateUuid, ClientCertificateRenewRequestDto request) throws NotFoundException, CertificateException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        return null;
    }

    @Hidden
    @Override
    public ClientCertificateDataResponseDto rekeyCertificate(String authorityUuid, String raProfileUuid, String certificateUuid, ClientCertificateRekeyRequestDto request) throws NotFoundException, CertificateException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        return null;
    }

    @Hidden
    @Override
    public List<BaseAttribute> listRevokeCertificateAttributes(String authorityUuid, String raProfileUuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Hidden
    @Override
    public void validateRevokeCertificateAttributes(String authorityUuid, String raProfileUuid, List<RequestAttributeDto> attributes) throws NotFoundException, ConnectorException, ValidationException {

    }

    @Hidden
    @Override
    public void revokeCertificate(String authorityUuid, String raProfileUuid, String certificateUuid, ClientCertificateRevocationDto request) throws NotFoundException {

    }
}