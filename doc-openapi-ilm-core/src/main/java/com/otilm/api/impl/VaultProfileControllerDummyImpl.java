package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.AttributeException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.VaultProfileController;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.common.PaginationResponseDto;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.connector.secrets.SecretType;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import com.czertainly.api.model.core.vaultprofile.VaultProfileDetailDto;
import com.czertainly.api.model.core.vaultprofile.VaultProfileDto;
import com.czertainly.api.model.core.vaultprofile.VaultProfileRequestDto;
import com.czertainly.api.model.core.vaultprofile.VaultProfileUpdateRequestDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class VaultProfileControllerDummyImpl implements VaultProfileController {
    @Override
    public PaginationResponseDto<VaultProfileDto> listVaultProfiles(SearchRequestDto searchRequest) {
        return null;
    }

    @Override
    public VaultProfileDetailDto getVaultProfileDetails(UUID vaultUuid, UUID vaultProfileUuid) throws NotFoundException {
        return null;
    }

    @Override
    public VaultProfileDetailDto updateVaultProfile(UUID vaultUuid, UUID vaultProfileUuid, VaultProfileUpdateRequestDto vaultProfileUpdateRequest) throws NotFoundException, AttributeException {
        return null;
    }

    @Override
    public void deleteVaultProfile(UUID vaultUuid, UUID vaultProfileUuid) throws NotFoundException {

    }

    @Override
    public VaultProfileDetailDto createVaultProfile(UUID vaultUuid, VaultProfileRequestDto vaultProfileDetail) throws NotFoundException, AttributeException, AlreadyExistException {
        return null;
    }

    @Override
    public void enableVaultProfile(UUID vaultUuid, UUID vaultProfileUuid) throws NotFoundException {

    }

    @Override
    public void disableVaultProfile(UUID vaultUuid, UUID vaultProfileUuid) throws NotFoundException {

    }

    @Override
    public List<BaseAttribute> listSecretAttributes(UUID vaultUuid, UUID vaultProfileUuid, SecretType secretType) throws ConnectorException, NotFoundException {
        return List.of();
    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return List.of();
    }
}
