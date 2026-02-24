package com.otilm.api.impl;

import com.czertainly.api.interfaces.connector.common.v2.HealthController;
import com.czertainly.api.model.client.connector.v2.HealthInfo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthControllerDummyImpl implements HealthController {

    @Override
    public HealthInfo checkHealth() {
        return null;
    }

    @Override
    public HealthInfo checkHealthLiveness() {
        return null;
    }

    @Override
    public HealthInfo checkHealthReadiness() {
        return null;
    }
}
