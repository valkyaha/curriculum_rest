package com.kittyvt.restapi.service.impl;

import com.kittyvt.restapi.domain.dao.impl.AboutMeDAO;
import com.kittyvt.restapi.domain.dto.AboutMeRecord;
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
    public Optional<AboutMeRecord> getAboutMe(final String language) {
        return aboutMeDAO.get(language);
    }
}
