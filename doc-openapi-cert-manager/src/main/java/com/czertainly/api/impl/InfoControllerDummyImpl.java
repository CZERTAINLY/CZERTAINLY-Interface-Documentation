package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.InfoController;
import com.czertainly.api.model.core.info.ActuatorHealthDto;
import com.czertainly.api.model.core.info.CoreInfoResponseDto;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoControllerDummyImpl implements InfoController {

    @Override
    public CoreInfoResponseDto getInfo() {
        return null;
    }

    @Hidden
    @Override
    public ActuatorHealthDto getHealthLiveness() {
        return null;
    }

    @Hidden
    @Override
    public ActuatorHealthDto getHealthReadiness() {
        return null;
    }

}
