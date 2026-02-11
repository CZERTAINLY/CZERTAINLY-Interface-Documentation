package com.otilm.api.impl;

import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.interfaces.connector.AttributesController;
import com.czertainly.api.model.client.attribute.RequestAttribute;
import com.czertainly.api.model.common.attribute.common.BaseAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttributesControllerDummyImpl implements AttributesController {
    @Override
    public List<BaseAttribute> listAttributeDefinitions(String kind) {
        return null;
    }

    @Override
    public void validateAttributes(String kind, List<RequestAttribute> attributes) throws ValidationException {

    }
}
