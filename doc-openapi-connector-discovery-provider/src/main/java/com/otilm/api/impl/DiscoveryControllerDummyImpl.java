package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.DiscoveryController;
import com.czertainly.api.model.connector.discovery.DiscoveryDataRequestDto;
import com.czertainly.api.model.connector.discovery.DiscoveryProviderDto;
import com.czertainly.api.model.connector.discovery.DiscoveryRequestDto;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DiscoveryControllerDummyImpl implements DiscoveryController {

	@Override
	public DiscoveryProviderDto discoverCertificate(DiscoveryRequestDto request) throws IOException, NotFoundException {
		return null;
	}

	@Override
	public DiscoveryProviderDto getDiscovery(String uuid, DiscoveryDataRequestDto request) throws IOException, NotFoundException {
		return null;
	}

	@Override
	public void deleteDiscovery(String uuid) throws IOException, NotFoundException {

	}
}
