package com.otilm.api.impl;

import com.czertainly.api.interfaces.connector.common.v2.MetricsController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsControllerDummyImpl implements MetricsController {

    @Override
    public String getMetrics() {
        return "";
    }
}
