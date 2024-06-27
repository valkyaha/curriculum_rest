package com.kittyvt.restapi.service.services;

import com.kittyvt.restapi.domain.dto.AboutMeDTO;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

public interface AboutMeService {
    Optional<AboutMeDTO> getAboutMe(final String language);

    void postAboutMe(AboutMeDTO lang);

    void deleteAboutMe(AboutMeDTO aboutMeDTO);

    void putAboutMe(String language, AboutMeDTO aboutMeDTO) throws HttpClientErrorException.NotFound;
}
