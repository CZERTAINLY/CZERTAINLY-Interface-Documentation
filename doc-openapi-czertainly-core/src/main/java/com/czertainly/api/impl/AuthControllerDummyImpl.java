package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.AuthController;
import com.czertainly.api.model.client.auth.UpdateUserRequestDto;
import com.czertainly.api.model.common.NameAndUuidDto;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.auth.ResourceDetailDto;
import com.czertainly.api.model.core.auth.UserDetailDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.CertificateException;
import java.util.List;

@RestController
public class AuthControllerDummyImpl implements AuthController {
    @Override
    public UserDetailDto profile() throws NotFoundException, JsonProcessingException {
        return null;
    }

    @Override
    public UserDetailDto updateUserProfile(UpdateUserRequestDto request) throws NotFoundException, JsonProcessingException, CertificateException {
        return null;
    }

    @Override
    public List<ResourceDetailDto> getAllResources() throws NotFoundException {
        return null;
    }

    @Override
    public List<NameAndUuidDto> getObjectsForResource(Resource resourceName) throws NotFoundException {
        return null;
    }
}
