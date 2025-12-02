package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.ConnectorAuthController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v3.DataAttributeV3;
import com.czertainly.api.model.core.connector.AuthType;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ConnectorAuthControllerDummyImpl implements ConnectorAuthController {
    @Override
    public Set<AuthType> getAuthenticationTypes() {
        return null;
    }

    @Override
    public List<DataAttributeV3> getBasicAuthAttributes() {
        return List.of();
    }


    @Override
    public void validateBasicAuthAttributes(List<RequestAttributeDto> attributes) {

    }

    @Override
    public List<DataAttributeV3> getCertificateAttributes() {
        return List.of();
    }

    @Override
    public void validateCertificateAttributes(List<RequestAttributeDto> attributes) {

    }

    @Override
    public List<DataAttributeV3> getApiKeyAuthAttributes() {
        return List.of();
    }

    @Override
    public void validateApiKeyAuthAttributes(List<RequestAttributeDto> attributes) {

    }

    @Override
    public List<DataAttributeV3> getJWTAuthAttributes() {
        return List.of();
    }

    @Override
    public void validateJWTAuthAttributes(List<RequestAttributeDto> attributes) {

    }


}

