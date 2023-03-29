package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.scep.ScepController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScepControllerDummyImpl implements ScepController {

    @Override
    public ResponseEntity<Object> doGet(String scepProfileName, String operation, String message) {
        return null;
    }

    @Override
    public ResponseEntity<Object> doPost(String scepProfileName, String operation, byte[] request) {
        return null;
    }
}
