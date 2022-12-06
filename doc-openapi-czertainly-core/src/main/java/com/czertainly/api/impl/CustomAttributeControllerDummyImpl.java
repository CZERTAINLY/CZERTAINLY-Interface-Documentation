package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.CustomAttributeController;
import com.czertainly.api.model.client.attribute.AttributeDefinitionDto;
import com.czertainly.api.model.client.attribute.custom.CustomAttributeCreateRequestDto;
import com.czertainly.api.model.client.attribute.custom.CustomAttributeDefinitionDetailDto;
import com.czertainly.api.model.client.attribute.custom.CustomAttributeUpdateRequestDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.auth.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomAttributeControllerDummyImpl implements CustomAttributeController {
    @Override
    public List<AttributeDefinitionDto> listCustomAttributes() {
        return null;
    }

    @Override
    public CustomAttributeDefinitionDetailDto getCustomAttribute(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<CustomAttributeDefinitionDetailDto> createCustomAttribute(CustomAttributeCreateRequestDto request) throws AlreadyExistException, NotFoundException {
        return null;
    }

    @Override
    public CustomAttributeDefinitionDetailDto editCustomAttribute(String uuid, CustomAttributeUpdateRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteCustomAttribute(String uuid) throws NotFoundException {

    }

    @Override
    public void enableCustomAttribute(String uuid) throws NotFoundException {

    }

    @Override
    public void disableCustomAttribute(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkDeleteCustomAttributes(List<String> attributeUuids) {

    }

    @Override
    public void bulkEnableCustomAttributes(List<String> attributeUuids) {

    }

    @Override
    public void bulkDisableCustomAttributes(List<String> attributeUuids) {

    }

    @Override
    public void updateResources(String uuid, List<Resource> resources) throws NotFoundException {

    }

    @Override
    public List<BaseAttribute> getResourceCustomAttributes(Resource resource) {
        return null;
    }

    @Override
    public List<Resource> getResources() {
        return null;
    }
}
