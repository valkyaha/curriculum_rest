package com.kittyvt.restapi.service.impl;

import com.kittyvt.restapi.domain.dao.impl.AboutMeDAO;
import com.kittyvt.restapi.domain.dto.AboutMeDTO;
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
    public Optional<AboutMeDTO> getAboutMe(final String language) {
        return aboutMeDAO.get(language);
    }

    @Override
    public void postAboutMe(AboutMeDTO aboutMeDTO) {
        aboutMeDAO.save(aboutMeDTO);
    }

    @Override
    public void deleteAboutMe(AboutMeDTO aboutMeDTO) {
        aboutMeDAO.delete(aboutMeDTO);
    }

    @Override
    public void putAboutMe(String language, AboutMeDTO aboutMeDTO) {
        aboutMeDAO.update(language, aboutMeDTO);
    }
}
