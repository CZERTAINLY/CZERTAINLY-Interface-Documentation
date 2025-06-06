package com.czertainly.api.impl;

import com.czertainly.api.exception.*;
import com.czertainly.api.interfaces.core.web.RAProfileManagementController;
import com.czertainly.api.model.client.approvalprofile.ApprovalProfileDto;
import com.czertainly.api.model.client.compliance.SimplifiedComplianceProfileDto;
import com.czertainly.api.model.client.raprofile.*;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.certificate.CertificateDetailDto;
import com.czertainly.api.model.core.raprofile.RaProfileCertificateValidationSettingsUpdateDto;
import com.czertainly.api.model.core.raprofile.RaProfileDto;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Optional;

@RestController
public class RAProfileManagementControllerDummyImpl implements RAProfileManagementController {

    @Hidden
    @Override
    public List<RaProfileDto> listRaProfiles(Optional<Boolean> enabled) {
        return null;
    }

    @Hidden
    @Override
    public ResponseEntity<?> createRaProfile(String authorityUuid, AddRaProfileRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException, AttributeException {
        return null;
    }

    @Hidden
    @Override
    public RaProfileDto getRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RaProfileDto getRaProfile(String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public RaProfileDto editRaProfile(String authorityUuid, String raProfileUuid, EditRaProfileRequestDto request) throws ConnectorException, AttributeException {
        return null;
    }

    @Override
    public RaProfileDto updateRaProfileValidationConfiguration(String authorityUuid, String raProfileUuid, RaProfileCertificateValidationSettingsUpdateDto request) {
        return null;
    }

    @Hidden
    @Override
    public void deleteRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public void deleteRaProfile(String raProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public void disableRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public void enableRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public void bulkDeleteRaProfile(List<String> uuids) throws NotFoundException, ValidationException {

    }

    @Hidden
    @Override
    public void bulkDisableRaProfile(List<String> uuids) throws NotFoundException {

    }

    @Hidden
    @Override
    public void bulkEnableRaProfile(List<String> uuids) throws NotFoundException {

    }

    @Hidden
    @Override
    public RaProfileAcmeDetailResponseDto getAcmeForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public RaProfileAcmeDetailResponseDto activateAcmeForRaProfile(String authorityUuid, String raProfileUuid, String acmeProfileUuid, ActivateAcmeForRaProfileRequestDto request) throws ConnectorException, AttributeException {
        return null;
    }

    @Hidden
    @Override
    public void deactivateAcmeForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public RaProfileScepDetailResponseDto getScepForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public RaProfileScepDetailResponseDto activateScepForRaProfile(String authorityUuid, String raProfileUuid, String scepProfileUuid, ActivateScepForRaProfileRequestDto request) throws ConnectorException, AttributeException {
        return null;
    }

    @Hidden
    @Override
    public void deactivateScepForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public RaProfileCmpDetailResponseDto getCmpForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public RaProfileCmpDetailResponseDto activateCmpForRaProfile(String authorityUuid, String raProfileUuid, String cmpProfileUuid, ActivateCmpForRaProfileRequestDto request) throws ConnectorException, AttributeException {
        return null;
    }

    @Hidden
    @Override
    public void deactivateCmpForRaProfile(String authorityUuid, String raProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public List<BaseAttribute> listRevokeCertificateAttributes(String authorityUuid, String raProfileUuid) throws ConnectorException {
        return null;
    }

    @Hidden
    @Override
    public List<BaseAttribute> listIssueCertificateAttributes(String authorityUuid, String raProfileUuid) throws ConnectorException {
        return null;
    }

    @Hidden
    @Override
    public void checkCompliance(List<String> uuids) throws NotFoundException {

    }

    @Hidden
    @Override
    public List<SimplifiedComplianceProfileDto> getAssociatedComplianceProfiles(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public List<ApprovalProfileDto> getAssociatedApprovalProfiles(String authorityUuid, String raProfileUuid) throws NotFoundException {
        return null;
    }

    @Hidden
    @Override
    public void associateRAProfileWithApprovalProfile(String authorityUuid, String raProfileUuid, String approvalProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public void disassociateRAProfileFromApprovalProfile(String authorityUuid, String raProfileUuid, String approvalProfileUuid) throws NotFoundException {

    }

    @Hidden
    @Override
    public List<CertificateDetailDto> getAuthorityCertificateChain(String authorityUuid, String raProfileUuid) throws ConnectorException, CertificateException, NoSuchAlgorithmException {
        return null;
    }

}
