package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.SettingController;
import com.czertainly.api.model.core.settings.*;
import com.czertainly.api.model.core.settings.authentication.AuthenticationSettingsDto;
import com.czertainly.api.model.core.settings.authentication.AuthenticationSettingsUpdateDto;
import com.czertainly.api.model.core.settings.authentication.OAuth2ProviderSettingsResponseDto;
import com.czertainly.api.model.core.settings.authentication.OAuth2ProviderSettingsUpdateDto;
import com.czertainly.api.model.core.settings.logging.LoggingSettingsDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("java:S1186")
public class SettingControllerDummyImpl implements SettingController {

    @Override
    public PlatformSettingsDto getPlatformSettings() {
        return null;
    }

    @Override
    public void updatePlatformSettings(PlatformSettingsUpdateDto platformSettingsDto) {

    }

    @Override
    public EventsSettingsDto getEventsSettings() {
        return null;
    }

    @Override
    public void updateEventsSettings(EventsSettingsDto eventsSettingsDto) throws NotFoundException {

    }

    @Override
    public void updateEventSettings(EventSettingsDto eventSettingsDto) throws NotFoundException {

    }

    @Override
    public AuthenticationSettingsDto getAuthenticationSettings() {
        return null;
    }

    @Override
    public void updateAuthenticationSettings(AuthenticationSettingsUpdateDto authenticationSettingsDto) {

    }

    @Override
    public OAuth2ProviderSettingsResponseDto getOAuth2ProviderSettings(String providerName) {
        return null;
    }

    @Override
    public void updateOAuth2ProviderSettings(String providerName, @Valid OAuth2ProviderSettingsUpdateDto oauth2SettingsDto) {

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
