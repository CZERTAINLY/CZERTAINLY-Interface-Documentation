package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.SettingController;
import com.czertainly.api.model.core.settings.NotificationSettingsDto;
import com.czertainly.api.model.core.settings.PlatformSettingsDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingControllerDummyImpl implements SettingController {

    @Override
    public PlatformSettingsDto getPlatformSettings() {
        return null;
    }

    @Override
    public void updatePlatformSettings(PlatformSettingsDto platformSettingsDto) {

    }

    @Override
    public NotificationSettingsDto getNotificationsSettings() {
        return null;
    }

    @Override
    public void updateNotificationsSettings(NotificationSettingsDto notificationSettingsDto) {

    }


}
