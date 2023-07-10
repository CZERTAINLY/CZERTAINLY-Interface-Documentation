package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.SchedulerException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.ApprovalProfileController;
import com.czertainly.api.model.client.approvalprofile.ApprovalProfileDetailDto;
import com.czertainly.api.model.client.approvalprofile.ApprovalProfileRequestDto;
import com.czertainly.api.model.client.approvalprofile.ApprovalProfileResponseDto;
import com.czertainly.api.model.client.approvalprofile.ApprovalProfileUpdateRequestDto;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.cert.CertificateException;

@RestController
public class ApprovalProfileControllerDummyImpl implements ApprovalProfileController {

    @Override
    public ApprovalProfileResponseDto listApprovalProfiles(PaginationRequestDto paginationRequestDto) throws ValidationException {
        return null;
    }

    @Override
    public ApprovalProfileDetailDto getApprovalProfile(String uuid) throws NotFoundException, CertificateException, IOException {
        return null;
    }

    @Override
    public void deleteApprovalProfile(String uuid) throws NotFoundException {

    }

    @Override
    public void enableApprovalProfile(String uuid) throws NotFoundException, SchedulerException {

    }

    @Override
    public void disableApprovalProfile(String uuid) throws NotFoundException, SchedulerException {

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
