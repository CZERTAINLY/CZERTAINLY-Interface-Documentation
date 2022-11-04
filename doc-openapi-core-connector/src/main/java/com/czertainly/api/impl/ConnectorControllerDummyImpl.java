package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.ConnectorController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.client.connector.ConnectDto;
import com.czertainly.api.model.client.connector.ConnectRequestDto;
import com.czertainly.api.model.client.connector.ConnectorRequestDto;
import com.czertainly.api.model.client.connector.ConnectorUpdateRequestDto;
import com.czertainly.api.model.common.BulkActionMessageDto;
import com.czertainly.api.model.common.HealthDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.connector.ConnectorDto;
import com.czertainly.api.model.core.connector.ConnectorStatus;
import com.czertainly.api.model.core.connector.FunctionGroupCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.ConnectException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ConnectorControllerDummyImpl implements ConnectorController {

    @Override
    public List<ConnectorDto> listConnectors(Optional<FunctionGroupCode> functionGroup, Optional<String> kind, Optional<ConnectorStatus> status) throws NotFoundException {
        return null;
    }

    @Override
    public ConnectorDto getConnector(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public ResponseEntity<?> createConnector(ConnectorRequestDto request) throws AlreadyExistException, ConnectorException {
        return null;
    }

    @Override
    public ConnectorDto editConnector(String uuid, ConnectorUpdateRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deleteConnector(String uuid) throws NotFoundException {

    }

    @Override
    public List<ConnectDto> connect(ConnectRequestDto request) throws ValidationException, ConnectException, ConnectorException {
        return null;
    }

    @Override
    public List<ConnectDto> reconnect(String uuid) throws ValidationException, ConnectException, ConnectorException {
        return null;
    }

    @Override
    public void bulkApprove(List<String> uuids) throws NotFoundException, ValidationException {

    }

    @Override
    public void bulkReconnect(List<String> uuids) throws ValidationException, ConnectException, ConnectorException {

    }

    @Override
    public void approve(String uuid) throws NotFoundException, ValidationException {

    }

    @Override
    public HealthDto checkHealth(String uuid) throws ValidationException, ConnectorException {
        return null;
    }

    @Override
    public List<BaseAttribute> getAttributes(String uuid, String functionGroup, String kind) throws ConnectorException {
        return null;
    }

    @Override
    public Map<FunctionGroupCode, Map<String, List<BaseAttribute>>> getAttributesAll(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public void validateAttributes(String uuid, String functionGroup, String kind, List<RequestAttributeDto> attributes) throws ConnectorException {

    }

    @Override
    public List<BulkActionMessageDto> bulkDeleteConnector(List<String> uuids) throws ValidationException, ConnectorException {
        return null;
    }

    @Override
    public List<BulkActionMessageDto> forceDeleteConnector(List<String> uuids) throws NotFoundException, ValidationException {
        return null;
    }
}
