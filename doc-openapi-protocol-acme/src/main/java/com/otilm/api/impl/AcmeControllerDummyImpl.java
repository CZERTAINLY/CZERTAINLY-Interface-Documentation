package com.otilm.api.impl;

import com.czertainly.api.exception.AcmeProblemDocumentException;
import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.ConnectorException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.core.acme.AcmeController;
import com.czertainly.api.model.core.acme.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RestController
public class AcmeControllerDummyImpl implements AcmeController {
    @Override
    public ResponseEntity<Directory> getDirectory(String acmeProfileName) throws NotFoundException, AcmeProblemDocumentException {
        return null;
    }

    @Override
    public ResponseEntity<?> getNonce(String acmeProfileName) {
        return null;
    }

    @Override
    public ResponseEntity<?> headNonce(String acmeProfileName) {
        return null;
    }

    @Override
    public ResponseEntity<Account> newAccount(String acmeProfileName, String jwsBody) throws AcmeProblemDocumentException, NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Account> updateAccount(String acmeProfileName, String accountId, String jwsBody) throws AcmeProblemDocumentException, NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<?> keyRollover(String acmeProfileName, String jwsBody) throws NotFoundException, AcmeProblemDocumentException {
        return null;
    }

    @Override
    public ResponseEntity<Order> newOrder(String acmeProfileName, String jwsBody) throws AcmeProblemDocumentException, NotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<List<Order>> listOrders(String acmeProfileName, String accountId) throws NotFoundException, AcmeProblemDocumentException {
        return null;
    }

    @Override
    public ResponseEntity<Authorization> getAuthorizations(String acmeProfileName, String authorizationId, String jwsBody) throws NotFoundException, AcmeProblemDocumentException {
        return null;
    }

    @Override
    public ResponseEntity<Challenge> validateChallenge(String acmeProfileName, String challengeId) throws NotFoundException, NoSuchAlgorithmException, InvalidKeySpecException, AcmeProblemDocumentException {
        return null;
    }

    @Override
    public ResponseEntity<Order> getOrder(String acmeProfileName, String orderId) throws NotFoundException, AcmeProblemDocumentException {
        return null;
    }

    @Override
    public ResponseEntity<Order> finalizeOrder(String acmeProfileName, String orderId, String jwsBody) throws AcmeProblemDocumentException, ConnectorException, JsonProcessingException, CertificateException, AlreadyExistException {
        return null;
    }

    @Override
    public ResponseEntity<Resource> downloadCertificate(String acmeProfileName, String certificateId) throws NotFoundException, CertificateException {
        return null;
    }

    @Override
    public ResponseEntity<?> revokeCertificate(String acmeProfileName, String jwsBody) throws AcmeProblemDocumentException, ConnectorException, CertificateException {
        return null;
    }
}
