package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.InfoController;
import com.czertainly.api.model.core.info.ActuatorHealthDto;
import com.czertainly.api.model.core.info.CoreInfoResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class InfoControllerDummyImpl implements InfoController {

    @Override
    @SecurityRequirements(value = {
            @SecurityRequirement(name = "")
    })
    public CoreInfoResponseDto getInfo() {
        return null;
    }

    @Override
    public ActuatorHealthDto getHealthLiveness() {
        return null;
    }

    @Override
    public ActuatorHealthDto getHealthReadiness() {
        return null;
    }

}
