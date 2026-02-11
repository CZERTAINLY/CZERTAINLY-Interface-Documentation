package com.otilm.api.impl;

import com.czertainly.api.exception.*;
import com.czertainly.api.interfaces.core.web.CryptographicKeyController;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.client.cryptography.CryptographicKeyResponseDto;
import com.czertainly.api.model.client.cryptography.key.*;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import com.czertainly.api.model.core.cryptography.key.*;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@SuppressWarnings("java:S1186")
public class CryptographicKeyControllerDummyImpl implements CryptographicKeyController {
    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return null;
    }

    @Override
    public CryptographicKeyResponseDto listCryptographicKeys(SearchRequestDto request) throws ValidationException {
        return null;
    }

    @Override
    public List<KeyDto> listKeyPairs(Optional<String> tokenProfileUuid) {
        return null;
    }

    @Override
    public KeyDetailDto getKey(String tokenInstanceUuid, String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public KeyDetailDto getKey(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public KeyItemDetailDto getKeyItem(String uuid, String keyItemUuid) throws NotFoundException {
        return null;
    }

    @Override
    public KeyItemDetailDto getKeyItem(String tokenInstanceUuid, String uuid, String keyItemUuid) throws NotFoundException {
        return null;
    }

    @Override
    public KeyDetailDto createKey(String tokenInstanceUuid, String tokenProfileUuid, KeyRequestType type, KeyRequestDto request) throws AlreadyExistException, ValidationException, ConnectorException {
        return null;
    }

    @Override
    public KeyDetailDto editKey(String uuid, EditKeyRequestDto request) throws ConnectorException, AttributeException {
        return null;
    }

    @Override
    public KeyItemDetailDto editKeyItem(String uuid, String keyItemUuid, EditKeyItemDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void syncKeys(String tokenInstanceUuid) throws ConnectorException {

    }

    @Override
    public void compromiseKey(String uuid, CompromiseKeyRequestDto request) throws NotFoundException {

    }

    @Override
    public void compromiseKey(String tokenInstanceUuid, String uuid, CompromiseKeyRequestDto request) throws NotFoundException {

    }

    @Override
    public void compromiseKeys(BulkCompromiseKeyRequestDto request) {

    }

    @Override
    public void compromiseKeyItems(BulkCompromiseKeyItemRequestDto request) {

    }

    @Override
    public void destroyKey(String uuid, List<String> keyItemUuids) throws ConnectorException {

    }

    @Override
    public void destroyKey(String tokenInstanceUuid, String uuid, List<String> keyItemUuids) throws ConnectorException {

    }

    @Override
    public void destroyKeys(List<String> keyUuids) throws ConnectorException {

    }

    @Override
    public void destroyKeyItems(List<String> keyItemUuids) throws ConnectorException {

    }

    @Override
    public void deleteKey(String uuid, List<String> keyItemUuids) throws ConnectorException {

    }

    @Override
    public void deleteKey(String tokenInstanceUuid, String uuid, List<String> keyItemUuids) throws ConnectorException {

    }

    @Override
    public void deleteKeys(List<String> keyUuids) throws ConnectorException {

    }

    @Override
    public void deleteKeyItems(List<String> keyItemUuids) throws ConnectorException {

    }

    @Override
    public void enableKey(String uuid, List<String> keyItemUuids) throws NotFoundException {

    }

    @Override
    public void enableKey(String tokenInstanceUuid, String uuid, List<String> keyItemUuids) throws NotFoundException {

    }

    @Override
    public void enableKeys(List<String> uuids) {

    }

    @Override
    public void enableKeyItems(List<String> uuids) {

    }

    @Override
    public void disableKey(String uuid, List<String> keyItemUuids) throws NotFoundException {

    }

    @Override
    public void disableKey(String tokenInstanceUuid, String uuid, List<String> keyItemUuids) throws NotFoundException {

    }

    @Override
    public void disableKeys(List<String> uuids) {

    }

    @Override
    public void disableKeyItems(List<String> uuids) {

    }

    @Override
    public void updateKeyUsages(String uuid, UpdateKeyUsageRequestDto request) throws NotFoundException, ValidationException {

    }

    @Override
    public void updateKeyUsages(String tokenInstanceUuid, String uuid, UpdateKeyUsageRequestDto request) throws NotFoundException, ValidationException {

    }

    @Override
    public void updateKeysUsages(BulkKeyUsageRequestDto request) {

    }

    @Override
    public void updateKeyItemUsages(BulkKeyItemUsageRequestDto request) {

    }

    @Override
    public List<BaseAttribute> listCreateKeyAttributes(String tokenInstanceUuid, String tokenProfileUuid, KeyRequestType type) throws ConnectorException {
        return null;
    }

    @Override
    public List<KeyEventHistoryDto> getEventHistory(String uuid, String keyItemUuid) throws NotFoundException {
        return List.of();
    }

    @Override
    public List<KeyEventHistoryDto> getEventHistory(String tokenInstanceUuid, String uuid, String keyItemUuid) throws NotFoundException {
        return null;
    }
}
