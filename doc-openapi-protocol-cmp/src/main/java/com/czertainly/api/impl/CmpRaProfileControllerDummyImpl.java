package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.cmp.CmpRaProfileController;
import com.czertainly.api.interfaces.core.cmp.error.CmpBaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CmpRaProfileControllerDummyImpl implements CmpRaProfileController {

    @Override
    public ResponseEntity<byte[]> doGet(String raProfileName, byte[] message) throws CmpBaseException {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> doPost(String raProfileName, byte[] request) throws CmpBaseException {
        return null;
    }

}
