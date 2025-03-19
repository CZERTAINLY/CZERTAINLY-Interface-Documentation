package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.ApprovalController;
import com.czertainly.api.model.client.approval.ApprovalDetailDto;
import com.czertainly.api.model.client.approval.ApprovalResponseDto;
import com.czertainly.api.model.client.approval.ApprovalUserDto;
import com.czertainly.api.model.client.approval.UserApprovalDto;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class ApprovalControllerDummyImpl implements ApprovalController {

    @Override
    public ApprovalResponseDto listApprovals(PaginationRequestDto paginationRequestDto) throws ValidationException {
        return null;
    }

    @Override
    public ApprovalResponseDto listUserApprovals(PaginationRequestDto paginationRequestDto, ApprovalUserDto approvalUserDto) throws ValidationException {
        return null;
    }

    @Override
    public ApprovalDetailDto getApproval(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public void approveApproval(String uuid) throws NotFoundException {

    }

    @Override
    public void rejectApproval(String uuid) throws NotFoundException {

    }

    @Override
    public void approveApprovalRecipient(String uuid, UserApprovalDto userApprovalDto) throws NotFoundException {

    }

    @Override
    public void rejectApprovalRecipient(String uuid, UserApprovalDto userApprovalDto) throws NotFoundException {

    }
}
