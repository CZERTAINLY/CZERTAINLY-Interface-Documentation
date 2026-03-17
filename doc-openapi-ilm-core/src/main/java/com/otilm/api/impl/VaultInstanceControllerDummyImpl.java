package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.AttributeException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.VaultInstanceController;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.common.PaginationResponseDto;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import com.czertainly.api.model.core.vault.VaultInstanceDetailDto;
import com.czertainly.api.model.core.vault.VaultInstanceDto;
import com.czertainly.api.model.core.vault.VaultInstanceRequestDto;
import com.czertainly.api.model.core.vault.VaultInstanceUpdateRequestDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class VaultInstanceControllerDummyImpl implements VaultInstanceController {
    @Override
    public List<BaseAttribute> listVaultInstanceAttributes(UUID connectorUuid) throws ConnectorException, NotFoundException {
        return List.of();
    }

    @Override
    public List<BaseAttribute> listVaultProfileAttributes(UUID uuid) throws ConnectorException, NotFoundException, AttributeException {
        return List.of();
    }

    @Override
    public VaultInstanceDetailDto getVaultInstanceDetails(UUID uuid) throws ConnectorException, NotFoundException, AttributeException {
        return null;
    }

    @Override
    public PaginationResponseDto<VaultInstanceDto> listVaultInstances(SearchRequestDto searchRequest) {
        return null;
    }

    @Override
    public void deleteVaultInstance(UUID uuid) throws NotFoundException {

    }

    @Override
    public VaultInstanceDetailDto createVaultInstance(VaultInstanceRequestDto vaultInstanceRequest) throws ConnectorException, NotFoundException, AttributeException, AlreadyExistException {
        return null;
    }

    @Override
    public VaultInstanceDetailDto updateVaultInstance(UUID uuid, VaultInstanceUpdateRequestDto vaultInstanceRequest) throws ConnectorException, NotFoundException, AttributeException {
        return null;
    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return List.of();
    }
}
