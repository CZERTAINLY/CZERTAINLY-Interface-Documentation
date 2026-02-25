package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.CbomRepositoryException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.core.web.CbomController;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.common.PaginationResponseDto;
import com.czertainly.api.model.core.cbom.CbomDetailDto;
import com.czertainly.api.model.core.cbom.CbomDto;
import com.czertainly.api.model.core.cbom.CbomUploadRequestDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class CbomControllerDummyImpl implements CbomController {

    @Override
    public PaginationResponseDto<CbomDto> listCboms(SearchRequestDto request) {
        return null;
    }

    @Override
    public CbomDetailDto getCbomDetail(UUID uuid) throws NotFoundException, CbomRepositoryException {
        return null;
    }

    @Override
    public List<CbomDto> listCbomVersions(UUID uuid) throws NotFoundException {
        return List.of();
    }

    @Override
    public CbomDto uploadCbom(CbomUploadRequestDto request) throws ValidationException, AlreadyExistException, CbomRepositoryException {
        return null;
    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return List.of();
    }
}
