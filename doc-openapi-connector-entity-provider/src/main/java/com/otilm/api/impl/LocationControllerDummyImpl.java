package com.otilm.api.impl;

import com.czertainly.api.exception.LocationException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.entity.LocationController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.connector.entity.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationControllerDummyImpl implements LocationController {
    @Override
    public LocationDetailResponseDto getLocationDetail(String entityUuid, LocationDetailRequestDto request) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public PushCertificateResponseDto pushCertificateToLocation(String entityUuid, PushCertificateRequestDto request) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public List<BaseAttribute> listPushCertificateAttributes(String entityUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validatePushCertificateAttributes(String entityUuid, List<RequestAttribute> pushAttributes) throws NotFoundException, ValidationException {

    }

    @Override
    public RemoveCertificateResponseDto removeCertificateFromLocation(String entityUuid, RemoveCertificateRequestDto request) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public GenerateCsrResponseDto generateCsrLocation(String entityUuid, GenerateCsrRequestDto request) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public List<BaseAttribute> listGenerateCsrAttributes(String entityUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validateGenerateCsrAttributes(String entityUuid, List<RequestAttribute> csrAttributes) throws NotFoundException, ValidationException {

    }
}
