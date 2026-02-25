package com.otilm.api.impl;

import com.czertainly.api.interfaces.connector.common.v2.InfoController;
import com.czertainly.api.model.client.connector.v2.InfoResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoControllerDummyImpl implements InfoController {


    @Override
    public InfoResponse getConnectorInfo() {
        return null;
    }
}
