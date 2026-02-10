package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.AcmeAccountController;
import com.czertainly.api.model.client.acme.AcmeAccountListResponseDto;
import com.czertainly.api.model.client.acme.AcmeAccountResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class AcmeAccountControllerDummyImpl implements AcmeAccountController {
    @Override
    public List<AcmeAccountListResponseDto> listAcmeAccounts() {
        return null;
    }

    @Override
    public AcmeAccountResponseDto getAcmeAccount(String acmeProfileUuid, String acmeAccountUuid) throws NotFoundException {
        return null;
    }

    @Override
    public void enableAcmeAccount(String acmeProfileUuid, String acmeAccountUuid) throws NotFoundException {

    }

    @Override
    public void disableAcmeAccount(String acmeProfileUuid, String acmeAccountUuid) throws NotFoundException {

    }

    @Override
    public void revokeAcmeAccount(String acmeProfileUuid, String acmeAccountUuid) throws NotFoundException {

    }

    @Override
    public void bulkEnableAcmeAccount(List<String> uuids) throws NotFoundException {

    }

    @Override
    public void bulkDisableAcmeAccount(List<String> uuids) throws NotFoundException {

    }

    @Override
    public void bulkRevokeAcmeAccount(List<String> uuids) throws NotFoundException {

    }
}
