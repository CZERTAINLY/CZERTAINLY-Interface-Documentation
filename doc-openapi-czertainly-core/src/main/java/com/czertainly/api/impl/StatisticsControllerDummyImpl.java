package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.StatisticsController;
import com.czertainly.api.model.client.dashboard.StatisticsDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class StatisticsControllerDummyImpl implements StatisticsController {

    @Override
    public StatisticsDto getStatistics(boolean includeArchived) {
        return null;
    }
}
