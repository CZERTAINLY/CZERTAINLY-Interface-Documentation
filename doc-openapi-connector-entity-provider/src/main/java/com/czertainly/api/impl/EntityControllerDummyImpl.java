package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.entity.EntityController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.connector.entity.EntityInstanceDto;
import com.czertainly.api.model.connector.entity.EntityInstanceRequestDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntityControllerDummyImpl implements EntityController {

    @Override
    public List<EntityInstanceDto> listEntityInstances() {
        return null;
    }

    @Override
    public EntityInstanceDto getEntityInstance(String entityUuid) throws NotFoundException {
        return null;
    }

    @Override
    public EntityInstanceDto createEntityInstance(EntityInstanceRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public EntityInstanceDto updateEntityInstance(String entityUuid, EntityInstanceRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void removeEntityInstance(String entityUuid) throws NotFoundException {

    }

    @Override
    public List<BaseAttribute> listLocationAttributes(String entityUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void validateLocationAttributes(String entityUuid, List<RequestAttributeDto> attributes) throws ValidationException, NotFoundException {

    }
}
