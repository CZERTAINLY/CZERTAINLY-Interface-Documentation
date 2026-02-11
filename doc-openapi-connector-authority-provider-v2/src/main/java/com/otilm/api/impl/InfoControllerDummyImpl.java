package com.otilm.api.impl;

import com.czertainly.api.interfaces.connector.InfoController;
import com.czertainly.api.model.client.connector.InfoResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoControllerDummyImpl implements InfoController {

    @Override
    public List<InfoResponse> listSupportedFunctions() {
        return null;
    }

}
