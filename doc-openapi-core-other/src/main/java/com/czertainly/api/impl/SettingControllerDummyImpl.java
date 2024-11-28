package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.SettingController;
import com.czertainly.api.model.core.settings.*;
import com.czertainly.api.model.core.settings.logging.LoggingSettingsDto;
import jakarta.validation.Valid;
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

    @Override
    public AuthenticationSettingsDto getAuthenticationSettings() {
        return null;
    }

    @Override
    public void updateAuthenticationSettings(AuthenticationSettingsUpdateDto authenticationSettingsDto) {

    }

    @Override
    public OAuth2ProviderSettingsDto getOAuth2ProviderSettings(String providerName) {
        return null;
    }

    @Override
    public void updateOAuth2ProviderSettings(String providerName, @Valid OAuth2ProviderSettingsDto oauth2SettingsDto) {

    }

    @Override
    public void removeOAuth2Provider(String providerName) {

    }

    @Override
    public LoggingSettingsDto getLoggingSettings() {
        return null;
    }

    @Override
    public void updateLoggingSettings(LoggingSettingsDto loggingSettingsDto) {

    }

}
