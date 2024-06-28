package com.kittyvt.restapi.service.services;

import com.kittyvt.restapi.domain.dto.AboutMeDto;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

public interface AboutMeService {
    Optional<AboutMeDto> getAboutMe(final String language);

    void postAboutMe(AboutMeDto lang);

    void deleteAboutMe(AboutMeDto aboutMeDTO);

    void putAboutMe(String language, AboutMeDto aboutMeDTO) throws HttpClientErrorException.NotFound;
}
