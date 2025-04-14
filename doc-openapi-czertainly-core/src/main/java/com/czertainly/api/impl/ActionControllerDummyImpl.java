package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.ActionController;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.workflows.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ActionControllerDummyImpl implements ActionController {

    @Override
    public List<ExecutionDto> listExecutions(Resource resource) {
        return List.of();
    }

    @Override
    public ExecutionDto createExecution(ExecutionRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public ExecutionDto getExecution(String executionUuid) throws NotFoundException {
        return null;
    }

    @Override
    public ExecutionDto updateExecution(String executionUuid, UpdateExecutionRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteExecution(String executionUuid) throws NotFoundException {

    }

    @Override
    public List<ActionDto> listActions(Resource resource) {
        return List.of();
    }

    @Override
    public ActionDetailDto createAction(ActionRequestDto request) throws NotFoundException, AlreadyExistException {
        return null;
    }

    @Override
    public ActionDetailDto getAction(String actionUuid) throws NotFoundException {
        return null;
    }

    @Override
    public ActionDetailDto updateAction(String actionUuid, UpdateActionRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteAction(String actionUuid) throws NotFoundException {

    }
}
