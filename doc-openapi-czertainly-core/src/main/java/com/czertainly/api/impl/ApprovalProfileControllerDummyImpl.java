package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.ApprovalProfileController;
import com.czertainly.api.model.client.approvalprofile.*;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ApprovalProfileControllerDummyImpl implements ApprovalProfileController {

    @Override
    public ApprovalProfileResponseDto listApprovalProfiles(PaginationRequestDto paginationRequestDto) throws ValidationException {
        return null;
    }

    @Override
    public ApprovalProfileDetailDto getApprovalProfile(String uuid, ApprovalProfileForVersionDto approvalProfileForVersionDto) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteApprovalProfile(String uuid) throws NotFoundException {
    }

    @Override
    public ResponseEntity<?> createApprovalProfile(ApprovalProfileRequestDto approvalProfileRequestDto) throws NotFoundException, AlreadyExistException {
        return null;
    }

    @Override
    public ResponseEntity<?> editApprovalProfile(String uuid, ApprovalProfileUpdateRequestDto approvalProfileUpdateRequestDto) throws NotFoundException {
        return null;
    }
}
