package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.interfaces.core.web.EntityInstanceController;
import com.czertainly.api.model.client.entity.EntityInstanceRequestDto;
import com.czertainly.api.model.client.entity.EntityInstanceUpdateRequestDto;
import com.czertainly.api.model.common.attribute.AttributeDefinition;
import com.czertainly.api.model.common.attribute.RequestAttributeDto;
import com.czertainly.api.model.core.entity.EntityInstanceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntityInstanceControllerDummyImpl implements EntityInstanceController {

    @Override
    public List<EntityInstanceDto> listEntityInstances() {
        return null;
    }

    @Override
    public EntityInstanceDto getEntityInstance(String entityUuid) throws ConnectorException {
        return null;
    }

    @Override
    public ResponseEntity<?> createEntityInstance(EntityInstanceRequestDto request) throws AlreadyExistException, ConnectorException {
        return null;
    }

    @Override
    public EntityInstanceDto updateEntityInstance(String entityUuid, EntityInstanceUpdateRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void removeEntityInstance(String entityUuid) throws ConnectorException {

    }

    @Override
    public List<AttributeDefinition> listLocationAttributes(String entityUuid) throws ConnectorException {
        return null;
    }

    @Override
    public void validateLocationAttributes(String entityUuid, List<RequestAttributeDto> attributes) throws ConnectorException {

    }
}
