package com.otilm.api.impl;

import com.czertainly.api.interfaces.core.web.StatisticsController;
import com.czertainly.api.model.client.dashboard.StatisticsDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsControllerDummyImpl implements StatisticsController {

    @Override
    public StatisticsDto getStatistics(boolean includeArchived) {
        return null;
    }
}
