package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.DiscoveryController;
import com.czertainly.api.model.client.certificate.DiscoveryResponseDto;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.client.discovery.DiscoveryCertificateResponseDto;
import com.czertainly.api.model.client.discovery.DiscoveryDto;
import com.czertainly.api.model.client.discovery.DiscoveryHistoryDetailDto;
import com.czertainly.api.model.core.scheduler.ScheduleDiscoveryDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.CertificateException;
import java.util.List;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class DiscoveryControllerDummyImpl implements DiscoveryController {

    @Override
    public DiscoveryResponseDto listDiscoveries(SearchRequestDto request) {
        return null;
    }

    @Override
    public DiscoveryHistoryDetailDto getDiscovery(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public DiscoveryCertificateResponseDto getDiscoveryCertificates(String uuid, Boolean newlyDiscovered, int itemsPerPage, int pageNumber) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<?> createDiscovery(DiscoveryDto request) throws AlreadyExistException, NotFoundException, CertificateException, InterruptedException, ConnectorException {
        return null;
    }

    @Override
    public void deleteDiscovery(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkDeleteDiscovery(List<String> discoveryUuids) throws NotFoundException {

    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return null;
    }

    @Override
    public ResponseEntity<?> scheduleDiscovery(ScheduleDiscoveryDto scheduleDiscoveryDto) throws AlreadyExistException, CertificateException, InterruptedException, ConnectorException {
        return null;
    }
}
