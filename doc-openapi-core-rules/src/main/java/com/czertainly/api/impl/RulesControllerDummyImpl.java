package com.czertainly.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.web.RuleController;
import com.czertainly.api.model.core.auth.Resource;
import com.czertainly.api.model.core.rules.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RulesControllerDummyImpl implements RuleController {
    @Override
    public List<RuleDto> listRules(Resource resource) {
        return null;
    }

    @Override
    public RuleDetailDto createRule(RuleRequestDto request) {
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

    @Override
    public List<RuleConditionGroupDto> listConditionGroups(Resource resource) {
        return null;
    }

    @Override
    public RuleConditionGroupDetailDto createConditionGroup(RuleConditionGroupRequestDto request) {
        return null;
    }

    @Override
    public RuleConditionGroupDetailDto getConditionGroup(String conditionGroupUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RuleConditionGroupDetailDto updateConditionGroup(String conditionGroupUuid, UpdateConditionGroupRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteConditionGroup(String conditionGroupUuid) throws NotFoundException {

    }

    @Override
    public List<RuleActionGroupDto> listActionGroups(Resource resource) {
        return null;
    }

    @Override
    public RuleActionGroupDetailDto createActionGroup(RuleActionGroupRequestDto request) {
        return null;
    }

    @Override
    public RuleActionGroupDetailDto getActionGroup(String actionGroupUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RuleActionGroupDetailDto updateActionGroup(String actionGroupUuid, UpdateActionGroupRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteActionGroup(String actionGroupUuid) throws NotFoundException {

    }

    @Override
    public List<RuleTriggerDto> listTriggers(Resource resource, Resource triggerResource) {
        return null;
    }

    @Override
    public RuleTriggerDetailDto createTrigger(RuleTriggerRequestDto request) {
        return null;
    }

    @Override
    public RuleTriggerDetailDto getTrigger(String triggerUuid) throws NotFoundException {
        return null;
    }

    @Override
    public RuleTriggerDetailDto updateTrigger(String triggerUuid, UpdateTriggerRequestDto request) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteTrigger(String triggerUuid) throws NotFoundException {

    }
}
