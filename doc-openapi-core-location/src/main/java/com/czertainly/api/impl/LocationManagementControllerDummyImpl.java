package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.LocationException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.LocationManagementController;
import com.czertainly.api.model.client.certificate.LocationsResponseDto;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.client.location.AddLocationRequestDto;
import com.czertainly.api.model.client.location.EditLocationRequestDto;
import com.czertainly.api.model.client.location.IssueToLocationRequestDto;
import com.czertainly.api.model.client.location.PushToLocationRequestDto;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.core.location.LocationDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationManagementControllerDummyImpl implements LocationManagementController {

    @Override
    public LocationsResponseDto listLocations(SearchRequestDto request) {
        return null;
    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return null;
    }

    @Override
    public ResponseEntity<?> addLocation(String entityUuid, AddLocationRequestDto request) throws NotFoundException, AlreadyExistException, LocationException {
        return null;
    }

    @Override
    public LocationDto getLocation(String entityUuid, String locationUuid) throws NotFoundException {
        return null;
    }

    @Override
    public LocationDto editLocation(String entityUuid, String locationUuid, EditLocationRequestDto request) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public void deleteLocation(String entityUuid, String locationUuid) throws NotFoundException {

    }

    @Override
    public void disableLocation(String entityUuid, String locationUuid) throws NotFoundException {

    }

    @Override
    public void enableLocation(String entityUuid, String locationUuid) throws NotFoundException {

    }

    @Override
    public List<BaseAttribute> listPushAttributes(String entityUuid, String locationUuid) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public List<BaseAttribute> listCsrAttributes(String entityUuid, String locationUuid) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public LocationDto pushCertificate(String entityUuid, String locationUuid, String certificateUuid, PushToLocationRequestDto request) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public LocationDto removeCertificate(String entityUuid, String locationUuid, String certificateUuid) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public LocationDto issueCertificate(String entityUuid, String locationUuid, IssueToLocationRequestDto request) throws ConnectorException, LocationException {
        return null;
    }

    @Override
    public LocationDto updateLocationContent(String entityUuid, String locationUuid) throws NotFoundException, LocationException {
        return null;
    }

    @Override
    public LocationDto renewCertificateInLocation(String entityUuid, String locationUuid, String certificateUuid) throws ConnectorException, LocationException {
        return null;
    }
}
