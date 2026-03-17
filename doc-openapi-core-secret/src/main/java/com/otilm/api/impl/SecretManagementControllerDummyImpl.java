package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.AttributeException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.SecretManagementController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.common.PaginationResponseDto;
import com.czertainly.api.model.connector.secrets.content.SecretContent;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import com.czertainly.api.model.core.secret.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class SecretManagementControllerDummyImpl implements SecretManagementController {
    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return List.of();
    }

    @Override
    public PaginationResponseDto<SecretDto> listSecrets(SearchRequestDto searchRequest) {
        return null;
    }

    @Override
    public SecretDetailDto getSecretDetails(UUID uuid) throws NotFoundException {
        return null;
    }

    @Override
    public List<SecretVersionDto> getSecretVersions(UUID uuid) throws NotFoundException {
        return List.of();
    }

    @Override
    public SecretContent getSecretContent(UUID uuid) throws NotFoundException, ConnectorException {
        return null;
    }

    @Override
    public SecretDetailDto createSecret(SecretRequestDto secretRequest, UUID vaultProfileUuid, UUID vaultUuid) throws NotFoundException, AttributeException, AlreadyExistException, ConnectorException {
        return null;
    }

    @Override
    public SecretDetailDto updateSecret(UUID uuid, SecretUpdateRequestDto secretRequest) throws NotFoundException, AttributeException, ConnectorException {
        return null;
    }

    @Override
    public void deleteSecret(UUID uuid) throws NotFoundException, ConnectorException {

    }

    @Override
    public void enableSecret(UUID uuid) throws NotFoundException {

    }

    @Override
    public void disableSecret(UUID uuid) throws NotFoundException {

    }

    @Override
    public void addVaultProfileToSecret(UUID uuid, UUID vaultProfileUuid, List<RequestAttribute> createSecretAttributes) throws NotFoundException, ConnectorException, AttributeException {

    }

    @Override
    public void removeVaultProfileFromSecret(UUID uuid, UUID vaultProfileUuid) throws NotFoundException, ConnectorException {

    }

    @Override
    public void updateSecretObjects(UUID uuid, SecretUpdateObjectsDto request) throws NotFoundException, ConnectorException, AttributeException {

    }
}
