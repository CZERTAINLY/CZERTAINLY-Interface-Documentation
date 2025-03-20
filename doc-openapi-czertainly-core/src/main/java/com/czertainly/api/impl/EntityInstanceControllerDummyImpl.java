package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.interfaces.core.web.EntityInstanceController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.client.certificate.EntityInstanceResponseDto;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.client.entity.EntityInstanceRequestDto;
import com.czertainly.api.model.client.entity.EntityInstanceUpdateRequestDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.entity.EntityInstanceDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class EntityInstanceControllerDummyImpl implements EntityInstanceController {

    @Override
    public EntityInstanceResponseDto listEntityInstances(SearchRequestDto request) {
        return null;
    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
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
    public EntityInstanceDto editEntityInstance(String entityUuid, EntityInstanceUpdateRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deleteEntityInstance(String entityUuid) throws ConnectorException {

    }

    @Override
    public List<BaseAttribute> listLocationAttributes(String entityUuid) throws ConnectorException {
        return null;
    }

    @Override
    public void validateLocationAttributes(String entityUuid, List<RequestAttributeDto> attributes) throws ConnectorException {

    }
}
