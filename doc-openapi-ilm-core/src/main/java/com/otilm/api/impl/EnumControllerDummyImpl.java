package com.otilm.api.impl;

import com.czertainly.api.interfaces.core.web.EnumController;
import com.czertainly.api.model.common.enums.PlatformEnum;
import com.czertainly.api.model.core.enums.EnumItemDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class EnumControllerDummyImpl implements EnumController {
    @Override
    public Map<PlatformEnum, Map<String, EnumItemDto>> getPlatformEnums() {
        return null;
    }
}
