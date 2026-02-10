package com.otilm.api.impl;

import com.czertainly.api.exception.*;
import com.czertainly.api.interfaces.core.web.CmpProfileController;
import com.czertainly.api.model.client.cmp.CmpProfileEditRequestDto;
import com.czertainly.api.model.client.cmp.CmpProfileRequestDto;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.core.certificate.CertificateDto;
import com.czertainly.api.model.core.cmp.CmpProfileDetailDto;
import com.czertainly.api.model.core.cmp.CmpProfileDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CmpProfileControllerDummyImpl implements CmpProfileController {

    @Override
    public List<CmpProfileDto> listCmpProfiles() {
        return List.of();
    }

    @Override
    public CmpProfileDetailDto getCmpProfile(String cmpProfileUuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<CmpProfileDetailDto> createCmpProfile(@Valid CmpProfileRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException, AttributeException {
        return null;
    }

    @Override
    public CmpProfileDetailDto editCmpProfile(String cmpProfileUuid, @Valid CmpProfileEditRequestDto request) throws ConnectorException, AttributeException {
        return null;
    }

    @Override
    public void deleteCmpProfile(String cmpProfileUuid) throws NotFoundException, ValidationException {

    }

    @Override
    public List<BulkActionMessageDto> bulkDeleteCmpProfile(List<String> cmpProfileUuids) {
        return List.of();
    }

    @Override
    public List<BulkActionMessageDto> forceDeleteCmpProfiles(List<String> cmpProfileUuids) throws NotFoundException, ValidationException {
        return List.of();
    }

    @Override
    public void enableCmpProfile(String cmpProfileUuid) throws NotFoundException {

    }

    @Override
    public void bulkEnableCmpProfile(List<String> cmpProfileUuids) {

    }

    @Override
    public void disableCmpProfile(String cmpProfileUuid) throws NotFoundException {

    }

    @Override
    public void bulkDisableCmpProfile(List<String> cmpProfileUuids) {

    }

    @Override
    public void updateRaProfile(String cmpProfileUuid, String raProfileUuid) throws NotFoundException {

    }

    @Override
    public List<CertificateDto> listCmpSigningCertificates() {
        return List.of();
    }

}
