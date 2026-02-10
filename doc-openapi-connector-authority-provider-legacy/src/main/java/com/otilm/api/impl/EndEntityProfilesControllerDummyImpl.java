package com.otilm.api.impl;

import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.interfaces.connector.EndEntityProfilesController;
import com.czertainly.api.model.common.NameAndIdDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EndEntityProfilesControllerDummyImpl implements EndEntityProfilesController {

    @Override
    public List<NameAndIdDto> listEntityProfiles(String uuid) throws NotFoundException {
        return null;
    }

    @Override
    public List<NameAndIdDto> listCertificateProfiles(String uuid, Integer endEntityProfileId) throws NotFoundException {
        return null;
    }

    @Override
    public List<NameAndIdDto> listCAsInProfile(String uuid, Integer endEntityProfileId) throws NotFoundException {
        return null;
    }

}
