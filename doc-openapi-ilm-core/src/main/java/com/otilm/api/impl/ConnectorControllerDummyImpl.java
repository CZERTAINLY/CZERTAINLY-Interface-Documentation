package com.otilm.api.impl;

import com.czertainly.api.exception.*;
import com.czertainly.api.interfaces.core.web.ConnectorController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.client.connector.ConnectDto;
import com.czertainly.api.model.client.connector.ConnectRequestDto;
import com.czertainly.api.model.client.connector.ConnectorRequestDto;
import com.czertainly.api.model.client.connector.ConnectorUpdateRequestDto;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.common.HealthDto;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.core.connector.ConnectorDto;
import com.czertainly.api.model.core.connector.ConnectorStatus;
import com.czertainly.api.model.core.connector.FunctionGroupCode;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.net.ConnectException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ConnectorControllerDummyImpl implements ConnectorController {


    @Override
    public List<ConnectorDto> listConnectors(Optional<FunctionGroupCode> functionGroup, Optional<String> kind, Optional<ConnectorStatus> status) throws NotFoundException {
        return List.of();
    }

    @Override
    public ConnectorDto getConnector(String uuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public ResponseEntity<?> createConnector(ConnectorRequestDto request) throws AlreadyExistException, ConnectorException, AttributeException, NotFoundException {
        return null;
    }

    @Override
    public ConnectorDto editConnector(String uuid, ConnectorUpdateRequestDto request) throws ConnectorException, AttributeException, NotFoundException {
        return null;
    }

    @Override
    public void deleteConnector(String uuid) throws NotFoundException {

    }

    @Override
    public List<ConnectDto> connect(ConnectRequestDto request) throws ValidationException, ConnectException, ConnectorException {
        return List.of();
    }

    @Override
    public List<ConnectDto> reconnect(String uuid) throws ValidationException, NotFoundException, ConnectException, ConnectorException {
        return List.of();
    }

    @Override
    public void bulkApprove(List<String> uuids) throws NotFoundException, ValidationException {

    }

    @Override
    public void bulkReconnect(List<String> uuids) throws ValidationException, NotFoundException, ConnectException, ConnectorException {

    }

    @Override
    public void approve(String uuid) throws NotFoundException, ValidationException {

    }

    @Override
    public HealthDto checkHealth(String uuid) throws NotFoundException, ValidationException, ConnectorException {
        return null;
    }

    @Override
    public List<BaseAttribute> getAttributes(String uuid, FunctionGroupCode functionGroup, String kind) throws NotFoundException, ConnectorException {
        return List.of();
    }

    @Override
    public Map<FunctionGroupCode, Map<String, List<BaseAttribute>>> getAttributesAll(String uuid) throws NotFoundException, ConnectorException {
        return Map.of();
    }

    @Override
    public void validateAttributes(String uuid, String functionGroup, String kind, List<RequestAttribute> attributes) throws NotFoundException, ConnectorException {

    }

    @Override
    public List<BulkActionMessageDto> bulkDeleteConnector(List<String> uuids) throws NotFoundException, ValidationException, ConnectorException {
        return List.of();
    }

    @Override
    public List<BulkActionMessageDto> forceDeleteConnector(List<String> uuids) throws NotFoundException, ValidationException {
        return List.of();
    }
}
