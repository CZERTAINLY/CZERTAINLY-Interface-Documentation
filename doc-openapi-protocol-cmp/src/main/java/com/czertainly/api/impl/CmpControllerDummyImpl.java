package com.czertainly.api.impl;

import com.czertainly.api.interfaces.core.cmp.CmpController;
import com.czertainly.api.interfaces.core.cmp.error.CmpBaseException;
import org.springframework.http.ResponseEntity;

public class CmpControllerDummyImpl implements CmpController {

    @Override
    public ResponseEntity<byte[]> doGet(String cmpProfileName, byte[] message) throws CmpBaseException {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> doPost(String cmpProfileName, byte[] request) throws CmpBaseException {
        return null;
    }

}
