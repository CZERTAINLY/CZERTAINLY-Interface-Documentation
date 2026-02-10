package com.otilm.api.impl;

import com.czertainly.api.interfaces.core.web.ConnectorAuthController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.common.attribute.common.DataAttribute;
import com.czertainly.api.model.core.connector.AuthType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ConnectorAuthControllerDummyImpl implements ConnectorAuthController {

    @Override
    public Set<AuthType> getAuthenticationTypes() {
        return Set.of();
    }

    @Override
    public List<DataAttribute> getBasicAuthAttributes() {
        return List.of();
    }

    @Override
    public void validateBasicAuthAttributes(List<RequestAttribute> attributes) {

    }


    @Override
    public List<DataAttribute> getCertificateAttributes() {
        return List.of();
    }

    @Override
    public void validateCertificateAttributes(List<RequestAttribute> attributes) {

    }


    @Override
    public List<DataAttribute> getApiKeyAuthAttributes() {
        return List.of();
    }

    @Override
    public void validateApiKeyAuthAttributes(List<RequestAttribute> attributes) {

    }


    @Override
    public List<DataAttribute> getJWTAuthAttributes() {
        return List.of();
    }

    @Override
    public void validateJWTAuthAttributes(List<RequestAttribute> attributes) {

    }

}
