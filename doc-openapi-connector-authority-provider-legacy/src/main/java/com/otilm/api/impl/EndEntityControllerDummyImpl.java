package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.EndEntityController;
import com.czertainly.api.model.core.authority.AddEndEntityRequestDto;
import com.czertainly.api.model.core.authority.EditEndEntityRequestDto;
import com.czertainly.api.model.core.authority.EndEntityDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EndEntityControllerDummyImpl implements EndEntityController {

    @Override
    public List<EndEntityDto> listEndEntities(String uuid, String endEntityProfileName) throws NotFoundException {
        return null;
    }

    @Override
    public EndEntityDto getEndEntity(String uuid, String endEntityProfileName, String endEntityName) throws NotFoundException {
        return null;
    }

    @Override
    public void createEndEntity(String uuid, String endEntityProfileName, AddEndEntityRequestDto request) throws NotFoundException, AlreadyExistException {

    }

    @Override
    public void updateEndEntity(String uuid, String endEntityProfileName, String endEntityName, EditEndEntityRequestDto request) throws NotFoundException {

    }

    @Override
    public void removeEndEntity(String uuid, String endEntityProfileName, String endEntityName) throws NotFoundException {

    }

    @Override
    public void resetPassword(String uuid, String endEntityProfileName, String endEntityName) throws NotFoundException {

    }

}
