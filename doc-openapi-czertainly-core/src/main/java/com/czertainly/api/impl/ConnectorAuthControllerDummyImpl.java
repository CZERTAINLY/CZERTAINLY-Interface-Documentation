package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.ConnectorAuthController;
import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
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
    public List<BaseAttribute> getBasicAuthAttributes() {
        return null;
    }

    @Override
    public void validateBasicAuthAttributes(List<RequestAttributeDto> attributes) {

    }

    @Override
    public List<BaseAttribute> getCertificateAttributes() {
        return null;
    }

    @Override
    public void validateCertificateAttributes(List<RequestAttributeDto> attributes) {

    }

    @Override
    public List<BaseAttribute> getApiKeyAuthAttributes() {
        return null;
    }

    @Override
    public void validateApiKeyAuthAttributes(List<RequestAttributeDto> attributes) {

    }

    @Override
    public List<BaseAttribute> getJWTAuthAttributes() {
        return null;
    }

    @Override
    public void validateJWTAuthAttributes(List<RequestAttributeDto> attributes) {

    }
}
