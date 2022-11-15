package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.RoleManagementController;
import com.czertainly.api.model.client.auth.RoleRequestDto;
import com.czertainly.api.model.core.auth.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleManagementControllerDummyImpl implements RoleManagementController {
    @Override
    public List<RoleDto> listRoles() {
        return null;
    }

    @Override
    public RoleDetailDto getRole(String roleUuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<RoleDetailDto> createRole(RoleRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public RoleDetailDto updateRole(String roleUuid, RoleRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteRole(String roleUuid) throws NotFoundException {

    }

    @Override
    public List<UserDto> getRoleUsers(String roleUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RoleDetailDto updateUsers(String roleUuid, List<String> userUuids) throws NotFoundException {
        return null;
    }

    @Override
    public SubjectPermissionsDto getRolePermissions(String roleUuid) throws NotFoundException {
        return null;
    }

    @Override
    public SubjectPermissionsDto savePermissions(String roleUuid, RolePermissionsRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public ResourcePermissionsDto getRoleResourcePermissions(String roleUuid, String resourceUuid) throws NotFoundException {
        return null;
    }

    @Override
    public List<ObjectPermissionsDto> getResourcePermissionObjects(String roleUuid, String resourceUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void addResourcePermissionObjects(String roleUuid, String resourceUuid, List<ObjectPermissionsRequestDto> request) throws NotFoundException {

    }

    @Override
    public void updateResourcePermissionObjects(String roleUuid, String resourceUuid, String objectUuid, ObjectPermissionsRequestDto request) throws NotFoundException {

    }

    @Override
    public void removeResourcePermissionObjects(String roleUuid, String resourceUuid, String objectUuid) throws NotFoundException {

    }
}
