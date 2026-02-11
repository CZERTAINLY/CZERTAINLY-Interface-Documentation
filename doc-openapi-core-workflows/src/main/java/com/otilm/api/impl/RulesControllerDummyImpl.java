package com.otilm.api.impl;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.RuleController;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.workflows.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RulesControllerDummyImpl implements RuleController {

    @Override
    public List<ConditionDto> listConditions(Resource resource) {
        return List.of();
    }

    @Override
    public ConditionDto createCondition(ConditionRequestDto request) throws AlreadyExistException {
        return null;
    }

    @Override
    public ConditionDto getCondition(String conditionUuid) throws NotFoundException {
        return null;
    }

    @Override
    public ConditionDto updateCondition(String conditionUuid, UpdateConditionRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteCondition(String conditionUuid) throws NotFoundException {

    }

    @Override
    public List<RuleDto> listRules(Resource resource) {
        return List.of();
    }

    @Override
    public RuleDetailDto createRule(RuleRequestDto request) throws NotFoundException, AlreadyExistException {
        return null;
    }

    @Override
    public RuleDetailDto getRule(String ruleUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RuleDetailDto updateRule(String ruleUuid, UpdateRuleRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteRule(String ruleUuid) throws NotFoundException {

    }
}
