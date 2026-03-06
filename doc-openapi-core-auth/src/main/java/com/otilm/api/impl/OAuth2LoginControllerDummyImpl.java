package com.otilm.api.impl;

import com.czertainly.api.interfaces.core.web.v2.OAuth2LoginController;
import com.czertainly.api.model.core.auth.LoginProviderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OAuth2LoginControllerDummyImpl implements OAuth2LoginController {
    @Override
    public List<LoginProviderDto> getOAuth2Providers(String error) {
        return List.of();
    }

    @Override
    public ResponseEntity<Void> loginWithProvider(String provider, String redirect) {
        return null;
    }
}
