package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.CertificateController;
import com.czertainly.api.model.core.authority.CertRevocationDto;
import com.czertainly.api.model.core.authority.CertificateSignRequestDto;
import com.czertainly.api.model.core.authority.CertificateSignResponseDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateControllerDummyImpl implements CertificateController {

    @Override
    public CertificateSignResponseDto issueCertificate(String uuid, String endEntityProfileName, CertificateSignRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void revokeCertificate(String uuid, String endEntityProfileName, CertRevocationDto request) throws NotFoundException {

    }

}
