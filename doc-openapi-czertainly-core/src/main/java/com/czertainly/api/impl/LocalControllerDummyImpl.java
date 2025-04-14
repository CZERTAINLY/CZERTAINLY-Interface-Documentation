package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.local.LocalController;
import com.czertainly.api.model.client.auth.AddUserRequestDto;
import com.czertainly.api.model.core.auth.UserDetailDto;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class LocalControllerDummyImpl implements LocalController {
    @Override
    public ResponseEntity<UserDetailDto> addAdmin(AddUserRequestDto request) throws CertificateException, NotFoundException, NoSuchAlgorithmException, AlreadyExistException {
        return null;
    }
}
