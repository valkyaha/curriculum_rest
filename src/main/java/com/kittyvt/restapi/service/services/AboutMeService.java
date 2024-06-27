package com.kittyvt.restapi.service.services;

import com.kittyvt.restapi.domain.dto.AboutMeRecord;

import java.util.Optional;

public interface AboutMeService {
    Optional<AboutMeRecord> getAboutMe(final String language);
}
