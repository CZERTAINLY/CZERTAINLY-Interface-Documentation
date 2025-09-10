package com.czertainly.api.impl;

import com.czertainly.api.interfaces.connector.HealthController;
import com.czertainly.api.model.common.HealthDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthControllerDummyImpl implements HealthController {

    @Override
    public HealthDto checkHealth() {
        return null;
    }

}
