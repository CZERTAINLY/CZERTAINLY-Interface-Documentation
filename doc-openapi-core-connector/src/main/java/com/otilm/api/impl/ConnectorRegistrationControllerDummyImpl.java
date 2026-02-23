package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.AttributeException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.connector.ConnectorRegistrationController;
import com.czertainly.api.model.client.connector.ConnectorRequestDto;
import com.czertainly.api.model.common.UuidDto;
import com.czertainly.api.model.core.connector.v2.ConnectorDetailDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectorRegistrationControllerDummyImpl implements ConnectorRegistrationController {
    @Override
    public UuidDto register(ConnectorRequestDto request) throws ConnectorException, AlreadyExistException {
        return null;
    }

    @Override
    public ConnectorDetailDto register(com.czertainly.api.model.core.connector.v2.ConnectorRequestDto request) throws ConnectorException, AlreadyExistException, AttributeException, NotFoundException {
        return null;
    }
}
