package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.interfaces.core.connector.ConnectorRegistrationController;
import com.czertainly.api.model.client.connector.ConnectorRequestDto;
import com.czertainly.api.model.common.UuidDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectorRegistrationControllerDummyImpl implements ConnectorRegistrationController {
    @Override
    public UuidDto register(ConnectorRequestDto request) throws ConnectorException, AlreadyExistException {
        return null;
    }
}
