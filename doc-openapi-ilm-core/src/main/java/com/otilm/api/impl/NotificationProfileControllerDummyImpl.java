package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.NotificationProfileController;
import com.czertainly.api.model.client.notification.NotificationProfileDetailDto;
import com.czertainly.api.model.client.notification.NotificationProfileRequestDto;
import com.czertainly.api.model.client.notification.NotificationProfileResponseDto;
import com.czertainly.api.model.client.notification.NotificationProfileUpdateRequestDto;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("java:S1186")
@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class NotificationProfileControllerDummyImpl implements NotificationProfileController {

    @Override
    public NotificationProfileResponseDto listNotificationProfiles(PaginationRequestDto paginationRequestDto) {
        return null;
    }

    @Override
    public NotificationProfileDetailDto getNotificationProfile(String uuid, Integer version) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteNotificationProfile(String uuid) throws NotFoundException {

    }

    @Override
    public ResponseEntity<?> createNotificationProfile(NotificationProfileRequestDto notificationProfileRequestDto) throws NotFoundException, AlreadyExistException {
        return null;
    }

    @Override
    public ResponseEntity<?> editNotificationProfile(String uuid, NotificationProfileUpdateRequestDto notificationProfileUpdateRequestDto) throws NotFoundException {
        return null;
    }
}
