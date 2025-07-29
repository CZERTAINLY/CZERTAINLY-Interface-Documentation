package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.CustomOidEntryController;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.core.oid.CustomOidEntryDetailResponseDto;
import com.czertainly.api.model.core.oid.CustomOidEntryListResponseDto;
import com.czertainly.api.model.core.oid.CustomOidEntryRequestDto;
import com.czertainly.api.model.core.oid.CustomOidEntryUpdateRequestDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;

import java.util.List;

public class CustomOidEntryControllerDummyImpl implements CustomOidEntryController {
    @Override
    public CustomOidEntryDetailResponseDto createCustomOidEntry(CustomOidEntryRequestDto requestDto) {
        return null;
    }

    @Override
    public CustomOidEntryDetailResponseDto getCustomOidEntry(String oid) throws NotFoundException {
        return null;
    }

    @Override
    public CustomOidEntryDetailResponseDto editCustomOidEntry(String oid, CustomOidEntryUpdateRequestDto updateDto) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteCustomOidEntry(String oid) throws NotFoundException {

    }

    @Override
    public void bulkDeleteCustomOidEntry(List<String> oids) {

    }

    @Override
    public CustomOidEntryListResponseDto listCustomOidEntries(SearchRequestDto searchRequestDto) {
        return null;
    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableInformation() {
        return List.of();
    }
}
