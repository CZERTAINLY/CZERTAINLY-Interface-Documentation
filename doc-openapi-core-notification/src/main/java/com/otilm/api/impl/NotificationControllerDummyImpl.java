package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.NotificationController;
import com.czertainly.api.model.client.notification.NotificationRequestDto;
import com.czertainly.api.model.client.notification.NotificationResponseDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("java:S1186")
@RestController
public class NotificationControllerDummyImpl implements NotificationController {
    @Override
    public NotificationResponseDto listNotifications(NotificationRequestDto request) throws ValidationException {
        return null;
    }

    @Override
    public void deleteNotification(String uuid) throws ValidationException, NotFoundException {

    }

    @Override
    public void markNotificationAsRead(String uuid) throws ValidationException, NotFoundException {
    }

    @Override
    public void bulkDeleteNotification(List<String> uuids) {

    }

    @Override
    public void bulkMarkNotificationAsRead(List<String> uuids) {

    }
}
