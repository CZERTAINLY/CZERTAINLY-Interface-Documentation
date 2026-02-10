package com.otilm.api.impl;

import com.czertainly.api.interfaces.core.web.AuditLogController;
import com.czertainly.api.model.client.certificate.SearchFilterRequestDto;
import com.czertainly.api.model.client.certificate.SearchRequestDto;
import com.czertainly.api.model.core.audit.AuditLogResponseDto;
import com.czertainly.api.model.core.search.SearchFieldDataByGroupDto;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirements(value = {
        @SecurityRequirement(name = "")
})
public class AuditLogControllerDummyImpl implements AuditLogController {

    @Override
    public AuditLogResponseDto listAuditLogs(SearchRequestDto requestDto) {
        return null;
    }

    @Override
    public ResponseEntity<Resource> exportAuditLogs(List<SearchFilterRequestDto> filters) {
        return null;
    }

    @Override
    public void purgeAuditLogs(List<SearchFilterRequestDto> filters) {

    }

    @Override
    public List<SearchFieldDataByGroupDto> getSearchableFieldInformation() {
        return List.of();
    }
}
