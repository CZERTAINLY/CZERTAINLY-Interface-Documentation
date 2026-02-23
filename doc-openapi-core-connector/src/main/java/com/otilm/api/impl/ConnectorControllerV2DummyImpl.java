package com.otilm.api.impl;

import com.czertainly.api.exception.*;
import com.czertainly.api.interfaces.core.web.v2.ConnectorController;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.client.connector.ConnectRequestDto;
import com.czertainly.api.model.client.connector.v2.ConnectorInfo;
import com.czertainly.api.model.client.connector.v2.HealthInfo;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.common.PaginationResponseDto;
import com.czertainly.api.model.core.connector.v2.*;
import org.springframework.web.bind.annotation.RestController;

import java.net.ConnectException;
import java.util.List;
import java.util.UUID;

@RestController
public class ConnectorControllerV2DummyImpl implements ConnectorController {

    @Override
    public PaginationResponseDto<ConnectorDto> listConnectors(SearchRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public ConnectorDetailDto getConnector(UUID uuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public ConnectorDetailDto createConnector(ConnectorRequestDto request) throws AlreadyExistException, ConnectorException, AttributeException, NotFoundException {
        return null;
    }

    @Override
    public ConnectorDetailDto editConnector(UUID uuid, ConnectorUpdateRequestDto request) throws ConnectorException, AttributeException, NotFoundException {
        return null;
    }

    @Override
    public void deleteConnector(UUID uuid) throws NotFoundException {

    }

    @Override
    public List<ConnectInfo> connect(ConnectRequestDto request) throws ValidationException, ConnectException, ConnectorException {
        return List.of();
    }

    @Override
    public ConnectInfo reconnect(UUID uuid) throws ValidationException, NotFoundException, ConnectException, ConnectorException {
        return null;
    }

    @Override
    public void approve(UUID uuid) throws NotFoundException, ValidationException {

    }

    @Override
    public List<BulkActionMessageDto> bulkApprove(List<UUID> uuids) throws NotFoundException, ValidationException {
        return List.of();
    }

    @Override
    public List<BulkActionMessageDto> bulkReconnect(List<UUID> uuids) throws ValidationException, NotFoundException, ConnectException, ConnectorException {
        return List.of();
    }

    @Override
    public List<BulkActionMessageDto> bulkDeleteConnector(List<UUID> uuids) throws NotFoundException, ValidationException, ConnectorException {
        return List.of();
    }

    @Override
    public List<BulkActionMessageDto> bulkForceDeleteConnector(List<UUID> uuids) throws NotFoundException, ValidationException {
        return List.of();
    }

    @Override
    public HealthInfo checkHealth(UUID uuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public ConnectorInfo getInfo(UUID uuid) throws NotFoundException, ConnectorException {
        return null;
    }
}
