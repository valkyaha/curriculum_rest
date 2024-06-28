package com.kittyvt.restapi.service.impl;

import com.kittyvt.restapi.domain.dao.impl.AboutMeDAO;
import com.kittyvt.restapi.domain.dto.AboutMeDto;
import com.kittyvt.restapi.service.services.AboutMeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class AboutMeServiceImpl implements AboutMeService {

    private final AboutMeDAO aboutMeDAO;

    public AboutMeServiceImpl(AboutMeDAO aboutMeDAO) {
        this.aboutMeDAO = aboutMeDAO;
    }

    @Override
    public Optional<AboutMeDto> getAboutMe(final String language) {
        return aboutMeDAO.get(language);
    }

    @Override
    public void postAboutMe(AboutMeDto aboutMeDTO) {
        aboutMeDAO.save(aboutMeDTO);
    }

    @Override
    public void deleteAboutMe(AboutMeDto aboutMeDTO) {
        aboutMeDAO.delete(aboutMeDTO);
    }

    @Override
    public void putAboutMe(String language, AboutMeDto aboutMeDTO) {
        aboutMeDAO.update(language, aboutMeDTO);
    }
}
