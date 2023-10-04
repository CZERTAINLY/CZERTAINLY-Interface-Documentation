package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.CertificateController;
import com.czertainly.api.model.client.approval.ApprovalResponseDto;
import com.czertainly.api.model.client.certificate.*;
import com.czertainly.api.model.common.UuidDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.certificate.*;
import com.czertainly.api.model.core.location.LocationDto;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import com.czertainly.api.model.core.v2.ClientCertificateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;

@RestController
public class CertificateControllerDummyImpl implements CertificateController {

    @Override
    public CertificateResponseDto listCertificates(SearchRequestDto request) throws ValidationException {
        return null;
    }

    @Override
    public CertificateDetailDto getCertificate(String uuid) throws NotFoundException, CertificateException, IOException {
        return null;
    }

    @Override
    public void deleteCertificate(String uuid) throws NotFoundException {

    }

    @Override
    public void updateCertificateObjects(String uuid, CertificateUpdateObjectsDto request) throws NotFoundException {

    }

    @Override
    public void check(String uuid) throws CertificateException, IOException, NotFoundException {

    }

    @Override
    public void bulkUpdateCertificateObjects(MultipleCertificateObjectUpdateDto request) throws NotFoundException {

    }

    @Override
    public ResponseEntity<UuidDto> upload(UploadCertificateRequestDto request) throws AlreadyExistException, CertificateException, NoSuchAlgorithmException {
        return null;
    }

    @Override
    public BulkOperationResponse bulkDeleteCertificate(RemoveCertificateDto request) throws NotFoundException {
        return null;
    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return null;
    }

    @Override
    public List<CertificateEventHistoryDto> getCertificateEventHistory(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public List<LocationDto> listLocations(String certificateUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void checkCompliance(CertificateComplianceCheckDto request) throws NotFoundException {

    }

    @Override
    public Map<String, CertificateValidationDto> getCertificateValidationResult(String uuid) throws NotFoundException, CertificateException, IOException {
        return null;
    }

    @Override
    public List<BaseAttribute> getCsrGenerationAttributes() {
        return null;
    }

    @Override
    public List<CertificateContentDto> getCertificateContent(List<String> uuids) {
        return null;
    }

    @Override
    public CertificateDetailDto submitCertificateRequest(ClientCertificateRequestDto request) throws ValidationException, NotFoundException, CertificateException, IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        return null;
    }

    @Override
    public CertificateChainResponseDto getCertificateChain(String uuid, boolean withEndCertificate) throws NotFoundException {
        return null;
    }

    @Override
    public CertificateChainDownloadResponseDto downloadCertificateChain(String uuid, CertificateFormat certificateFormat, boolean withEndCertificate) throws NotFoundException, CertificateException, IOException {
        return null;
    }

    @Override
    public ApprovalResponseDto listCertificateApprovals(String uuid, PaginationRequestDto paginationRequestDto) {
        return null;
    }
}
