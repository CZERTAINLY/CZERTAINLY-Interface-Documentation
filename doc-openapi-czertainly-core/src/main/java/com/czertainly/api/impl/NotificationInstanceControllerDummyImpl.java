package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.interfaces.core.web.NotificationInstanceController;
import com.czertainly.api.model.common.attribute.v2.DataAttribute;
import com.czertainly.api.model.core.notification.NotificationInstanceDto;
import com.czertainly.api.model.core.notification.NotificationInstanceRequestDto;
import com.czertainly.api.model.core.notification.NotificationInstanceUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationInstanceControllerDummyImpl implements NotificationInstanceController {

    @Override
    public List<NotificationInstanceDto> listNotificationInstances() {
        return null;
    }

    @Override
    public NotificationInstanceDto getNotificationInstance(String uuid) throws ConnectorException {
        return null;
    }

    @Override
    public ResponseEntity<?> createNotificationInstance(NotificationInstanceRequestDto request) throws AlreadyExistException, ConnectorException {
        return null;
    }

    @Override
    public NotificationInstanceDto editNotificationInstance(String uuid, NotificationInstanceUpdateRequestDto request) throws ConnectorException {
        return null;
    }

    @Override
    public void deleteNotificationInstance(String uuid) throws ConnectorException {

    }

    @Override
    public List<DataAttribute> listMappingAttributes(String kind) {
        return null;
    }
}
