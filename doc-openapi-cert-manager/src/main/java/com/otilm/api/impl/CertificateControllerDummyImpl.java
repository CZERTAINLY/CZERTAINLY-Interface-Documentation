package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.CertificateController;
import com.czertainly.api.model.client.approval.ApprovalResponseDto;
import com.czertainly.api.model.client.certificate.*;
import com.czertainly.api.model.common.UuidDto;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.core.certificate.*;
import com.czertainly.api.model.core.location.LocationDto;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import com.czertainly.api.model.core.v2.ClientCertificateRequestDto;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.UUID;

@RestController
public class CertificateControllerDummyImpl implements CertificateController {

    @Hidden
    @Override
    public CertificateResponseDto listCertificates(CertificateSearchRequestDto request) throws ValidationException {
        return null;
    }

    @Override
    public CertificateDetailDto getCertificate(UUID uuid) throws NotFoundException, CertificateException, IOException {
        return null;
    }

    @Hidden
    @Override
    public CertificateDownloadResponseDto downloadCertificate(UUID uuid, CertificateFormat certificateFormat, CertificateFormatEncoding encoding) throws NotFoundException, CertificateException, IOException {
        return null;
    }

    @Hidden
    @Override
    public void deleteCertificate(UUID uuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public void updateCertificateObjects(UUID uuid, CertificateUpdateObjectsDto request) throws NotFoundException {

    }

    @Hidden
    @Override
    public void bulkUpdateCertificateObjects(MultipleCertificateObjectUpdateDto request) throws NotFoundException {

    }

    @Hidden
    @Override
    public ResponseEntity<UuidDto> upload(UploadCertificateRequestDto request) throws AlreadyExistException, CertificateException, NoSuchAlgorithmException {
        return null;
    }

    @Hidden
    @Override
    public BulkOperationResponse bulkDeleteCertificate(RemoveCertificateDto request) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return null;
    }

    @Override
    public List<CertificateEventHistoryDto> getCertificateEventHistory(UUID uuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public List<LocationDto> listLocations(UUID certificateUuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public void checkCompliance(CertificateComplianceCheckDto request) throws NotFoundException {

    }

    @Hidden
    @Override
    public CertificateValidationResultDto getCertificateValidationResult(UUID uuid) throws NotFoundException, CertificateException {
        return null;
    }

    @Hidden
    @Override
    public List<BaseAttribute> getCsrGenerationAttributes() {
        return null;
    }

    @Hidden
    @Override
    public List<CertificateContentDto> getCertificateContent(List<UUID> uuids) {
        return null;
    }

    @Hidden
    @Override
    public CertificateDetailDto submitCertificateRequest(ClientCertificateRequestDto request) throws ValidationException, NotFoundException, CertificateException, IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        return null;
    }

    @Hidden
    @Override
    public CertificateChainResponseDto getCertificateChain(UUID uuid, boolean withEndCertificate) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public CertificateChainDownloadResponseDto downloadCertificateChain(UUID uuid, CertificateFormat certificateFormat, boolean withEndCertificate, CertificateFormatEncoding encoding) throws NotFoundException, CertificateException {
        return null;
    }

    @Override
    public ApprovalResponseDto listCertificateApprovals(UUID uuid, PaginationRequestDto paginationRequestDto) {
        return null;
    }

    @Override
    public void archiveCertificate(UUID uuid) throws NotFoundException {

    }

    @Override
    public void unarchiveCertificate(UUID uuid) throws NotFoundException {

    }

    @Override
    public void bulkArchiveCertificate(List<UUID> uuids) {

    }

    @Override
    public void bulkUnarchiveCertificate(List<UUID> uuids) {

    }

    @Override
    public CertificateRelationsDto getCertificateRelations(UUID uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void associateCertificates(UUID uuid, UUID certificateUuid) throws NotFoundException {

    }

    @Override
    public void removeCertificateAssociation(UUID uuid, UUID certificateUuid) throws NotFoundException {

    }
}
