package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.UserManagementController;
import com.czertainly.api.model.client.auth.AddUserRequestDto;
import com.czertainly.api.model.client.auth.UpdateUserRequestDto;
import com.czertainly.api.model.client.auth.UserIdentificationRequestDto;
import com.czertainly.api.model.core.auth.RoleDto;
import com.czertainly.api.model.core.auth.SubjectPermissionsDto;
import com.czertainly.api.model.core.auth.UserDetailDto;
import com.czertainly.api.model.core.auth.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.CertificateException;
import java.util.List;

@RestController
public class UserManagementControllerDummyImpl implements UserManagementController {
    @Override
    public List<UserDto> listUsers() {
        return null;
    }

    @Override
    public UserDetailDto getUser(String userUuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<UserDetailDto> createUser(AddUserRequestDto request) throws NotFoundException, CertificateException {
        return null;
    }

    @Override
    public UserDetailDto updateUser(String userUuid, UpdateUserRequestDto request) throws NotFoundException, CertificateException {
        return null;
    }

    @Override
    public UserDetailDto enableUser(String userUuid) throws NotFoundException {
        return null;
    }

    @Override
    public UserDetailDto disableUser(String userUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteUser(String userUuid) throws NotFoundException {

    }

    @Override
    public List<RoleDto> getUserRoles(String userUuid) throws NotFoundException {
        return null;
    }

    @Override
    public UserDetailDto updateRoles(String userUuid, List<String> roleUuids) throws NotFoundException {
        return null;
    }

    @Override
    public UserDetailDto addRole(String userUuid, String roleUuid) throws NotFoundException {
        return null;
    }

    @Override
    public UserDetailDto removeRole(String userUuid, String roleUuid) throws NotFoundException {
        return null;
    }

    @Override
    public SubjectPermissionsDto getPermissions(String userUuid) throws NotFoundException {
        return null;
    }

    @Override
    public UserDetailDto identifyUser(UserIdentificationRequestDto request) throws NotFoundException, CertificateException {
        return null;
    }
}
