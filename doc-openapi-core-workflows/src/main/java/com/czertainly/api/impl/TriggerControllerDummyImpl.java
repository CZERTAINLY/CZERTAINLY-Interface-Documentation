package com.czertainly.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.TriggerController;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.workflows.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TriggerControllerDummyImpl implements TriggerController {

    @Override
    public List<TriggerDto> listTriggers(Resource resource, Resource eventResource) {
        return List.of();
    }

    @Override
    public TriggerDetailDto createTrigger(TriggerRequestDto request) throws NotFoundException, AlreadyExistException {
        return null;
    }

    @Override
    public TriggerDetailDto getTrigger(String triggerUuid) throws NotFoundException {
        return null;
    }

    @Override
    public TriggerDetailDto updateTrigger(String triggerUuid, UpdateTriggerRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteTrigger(String triggerUuid) throws NotFoundException {

    }

    @Override
    public List<TriggerHistoryDto> getTriggerHistory(String triggerUuid, String associationObjectUuid) {
        return List.of();
    }

    @Override
    public TriggerHistorySummaryDto getTriggerHistorySummary(String associationObjectUuid) throws NotFoundException {
        return null;
    }
}
