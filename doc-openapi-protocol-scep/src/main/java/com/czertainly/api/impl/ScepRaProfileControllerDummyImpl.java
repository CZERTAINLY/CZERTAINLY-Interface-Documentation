package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.scep.ScepRaProfileController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScepRaProfileControllerDummyImpl implements ScepRaProfileController {

    @Override
    public ResponseEntity<Object> doGet(String raProfileName, String operation, String message) {
        return null;
    }

    @Override
    public ResponseEntity<Object> doPost(String raProfileName, String operation, byte[] request) {
        return null;
    }
}
