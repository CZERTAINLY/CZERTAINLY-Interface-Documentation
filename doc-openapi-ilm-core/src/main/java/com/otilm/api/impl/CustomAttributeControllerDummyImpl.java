package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.AttributeException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.CustomAttributeController;
import com.czertainly.api.model.client.attribute.ResponseAttribute;
import com.czertainly.api.model.client.attribute.custom.CustomAttributeCreateRequestDto;
import com.czertainly.api.model.client.attribute.custom.CustomAttributeDefinitionDetailDto;
import com.czertainly.api.model.client.attribute.custom.CustomAttributeDefinitionDto;
import com.czertainly.api.model.client.attribute.custom.CustomAttributeUpdateRequestDto;
import com.czertainly.api.model.common.attribute.common.AttributeContent;
import com.czertainly.api.model.common.attribute.common.CustomAttribute;
import com.czertainly.api.model.common.attribute.common.content.AttributeContentType;
import com.czertainly.api.model.core.auth.Resource;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class CustomAttributeControllerDummyImpl implements CustomAttributeController {
    @Override
    public List<CustomAttributeDefinitionDto> listCustomAttributes(AttributeContentType attributeContentType) {
        return null;
    }

    @Override
    public CustomAttributeDefinitionDetailDto getCustomAttribute(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<CustomAttributeDefinitionDetailDto> createCustomAttribute(CustomAttributeCreateRequestDto request) throws AlreadyExistException {
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
    public List<CustomAttribute> getResourceCustomAttributes(Resource resource) {
        return List.of();
    }


    @Override
    public List<Resource> getResources() {
        return null;
    }

    @Override
    public List<ResponseAttribute> updateAttributeContentForResource(Resource resourceName, String objectUuid, String attributeUuid, List<AttributeContent> request) throws NotFoundException, AttributeException {
        return List.of();
    }

    @Override
    public List<ResponseAttribute> deleteAttributeContentForResource(Resource resourceName, String objectUuid, String attributeUuid) throws NotFoundException, AttributeException {
        return List.of();
    }
}
