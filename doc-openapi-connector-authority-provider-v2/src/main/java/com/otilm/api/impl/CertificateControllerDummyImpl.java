package com.otilm.api.impl;

import com.czertainly.api.exception.CertificateOperationException;
import com.czertainly.api.exception.CertificateRequestException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.v2.CertificateController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.connector.v2.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CertificateControllerDummyImpl implements CertificateController {


    @Override
    public List<BaseAttribute> listIssueCertificateAttributes(String uuid) throws NotFoundException {
        return List.of();
    }

    @Override
    public void validateIssueCertificateAttributes(String uuid, List<RequestAttribute> attributes) throws NotFoundException, ValidationException {

    }

    @Override
    public CertificateDataResponseDto issueCertificate(String uuid, CertificateSignRequestDto request) throws NotFoundException, CertificateOperationException, CertificateRequestException {
        return null;
    }

    @Override
    public CertificateDataResponseDto renewCertificate(String uuid, CertificateRenewRequestDto request) throws NotFoundException, CertificateOperationException, CertificateRequestException {
        return null;
    }

    @Override
    public List<BaseAttribute> listRevokeCertificateAttributes(String uuid) throws NotFoundException {
        return List.of();
    }

    @Override
    public void validateRevokeCertificateAttributes(String uuid, List<RequestAttribute> attributes) throws NotFoundException, ValidationException {

    }

    @Override
    public void revokeCertificate(String uuid, CertRevocationDto request) throws NotFoundException, CertificateOperationException {

    }

    @Override
    public CertificateIdentificationResponseDto identifyCertificate(String uuid, CertificateIdentificationRequestDto request) throws NotFoundException, ValidationException {
        return null;
    }
}
