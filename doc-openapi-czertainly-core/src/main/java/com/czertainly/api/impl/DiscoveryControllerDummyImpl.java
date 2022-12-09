package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.DiscoveryController;
import com.czertainly.api.model.client.discovery.DiscoveryDto;
import com.czertainly.api.model.client.discovery.DiscoveryHistoryDetailDto;
import com.czertainly.api.model.client.discovery.DiscoveryHistoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.CertificateException;
import java.util.List;

@RestController
public class DiscoveryControllerDummyImpl implements DiscoveryController {
    @Override
    public List<DiscoveryHistoryDto> listDiscoveries() {
        return null;
    }

    @Override
    public DiscoveryHistoryDetailDto getDiscovery(String uuid) throws NotFoundException {
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
}
