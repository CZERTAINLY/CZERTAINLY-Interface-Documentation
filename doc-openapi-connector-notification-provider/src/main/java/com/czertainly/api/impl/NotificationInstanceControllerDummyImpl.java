package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.NotificationInstanceController;
import com.czertainly.api.model.common.attribute.common.DataAttribute;
import com.czertainly.api.model.connector.notification.NotificationProviderInstanceDto;
import com.czertainly.api.model.connector.notification.NotificationProviderInstanceRequestDto;
import com.czertainly.api.model.connector.notification.NotificationProviderNotifyRequestDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationInstanceControllerDummyImpl implements NotificationInstanceController {

    @Override
    public List<NotificationProviderInstanceDto> listNotificationInstances() {
        return null;
    }

    @Override
    public NotificationProviderInstanceDto getNotificationInstance(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public NotificationProviderInstanceDto createNotificationInstance(NotificationProviderInstanceRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public NotificationProviderInstanceDto updateNotificationInstance(String uuid, NotificationProviderInstanceRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void removeNotificationInstance(String uuid) throws NotFoundException {

    }

    @Override
    public void sendNotification(String uuid, NotificationProviderNotifyRequestDto request) throws NotFoundException {

    }

    @Override
    public List<DataAttribute<?>> listMappingAttributes(String kind) {
        return List.of();
    }

}
