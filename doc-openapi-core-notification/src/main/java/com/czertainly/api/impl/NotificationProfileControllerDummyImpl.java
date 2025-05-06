package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.NotificationProfileController;
import com.czertainly.api.model.client.notification.*;
import com.czertainly.api.model.core.scheduler.PaginationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("java:S1186")
@RestController
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
