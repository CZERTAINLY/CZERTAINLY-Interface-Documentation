package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.web.AuditLogController;
import com.czertainly.api.model.core.audit.AuditLogFilter;
import com.czertainly.api.model.core.audit.AuditLogResponseDto;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditLogControllerDummyImpl implements AuditLogController {
    @Override
    public AuditLogResponseDto listAuditLogs(AuditLogFilter filter, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Resource> exportAuditLogs(AuditLogFilter filter, Pageable pageable) {
        return null;
    }

    @Override
    public void purgeAuditLogs(AuditLogFilter filter, Pageable pageable) {

    }

    @Override
    public List<String> listObjects() {
        return null;
    }

    @Override
    public List<String> listOperations() {
        return null;
    }

    @Override
    public List<String> listOperationStatuses() {
        return null;
    }
}
