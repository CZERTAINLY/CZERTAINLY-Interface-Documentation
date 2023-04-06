package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.GlobalMetadataController;
import com.czertainly.api.model.client.attribute.AttributeDefinitionDto;
import com.czertainly.api.model.client.attribute.metadata.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GlobalMetadataControllerDummyImpl implements GlobalMetadataController {
    @Override
    public List<AttributeDefinitionDto> listGlobalMetadata() {
        return null;
    }

    @Override
    public GlobalMetadataDefinitionDetailDto getGlobalMetadata(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<GlobalMetadataDefinitionDetailDto> createGlobalMetadata(GlobalMetadataCreateRequestDto request) throws AlreadyExistException, NotFoundException {
        return null;
    }

    @Override
    public GlobalMetadataDefinitionDetailDto editGlobalMetadata(String uuid, GlobalMetadataUpdateRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteGlobalMetadata(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkDeleteGlobalMetadata(List<String> attributeUuids) {

    }

    @Override
    public List<ConnectorMetadataResponseDto> getConnectorMetadata(Optional<String> connectorUuid) throws NotFoundException {
        return null;
    }

    @Override
    public GlobalMetadataDefinitionDetailDto promoteConnectorMetadata(ConnectorMetadataPromotionRequestDto request) throws NotFoundException {
        return null;
    }
}