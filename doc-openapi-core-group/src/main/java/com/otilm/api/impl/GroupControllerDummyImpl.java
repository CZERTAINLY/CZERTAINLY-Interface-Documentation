package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.GroupController;
import com.czertainly.api.model.core.certificate.group.GroupDto;
import com.czertainly.api.model.core.certificate.group.GroupRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupControllerDummyImpl implements GroupController {
    @Override
    public List<GroupDto> listGroups() {
        return null;
    }

    @Override
    public GroupDto getGroup(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<?> createGroup(GroupRequestDto request) throws AlreadyExistException, NotFoundException {
        return null;
    }

    @Override
    public GroupDto editGroup(String uuid, GroupRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteGroup(String uuid) throws NotFoundException {

    }

    @Override
    public void bulkDeleteGroup(List<String> groupUuids) {

    }
}
