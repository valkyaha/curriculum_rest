package com.kittyvt.restapi.domain.dao.impl;

import com.kittyvt.restapi.domain.AboutMe;
import com.kittyvt.restapi.domain.dao.DAO;
import com.kittyvt.restapi.domain.dto.AboutMeDto;
import com.kittyvt.restapi.domain.mapper.AboutMeMapper;
import com.kittyvt.restapi.repository.AboutMeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class AboutMeDAO implements DAO<AboutMeDto> {

    private final AboutMeRepository aboutMeRepository;

    public AboutMeDAO(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    @Override
    public Optional<AboutMeDto> get(String language) {
        return aboutMeRepository.findByLanguage(language).map(AboutMeMapper.INSTANCE::toRecord);
    }

    @Override
    public void save(AboutMeDto aboutMeDTO) {
        aboutMeRepository.save(AboutMeMapper.INSTANCE.toEntity(aboutMeDTO));
    }

    @Override
    public void update(String lang, AboutMeDto after) {
        Optional<AboutMe> before = aboutMeRepository.findByLanguage(lang);
        before.ifPresent(update -> aboutMeRepository.save(AboutMeMapper.INSTANCE.partialUpdate(after, update)));
    }

    @Override
    public void delete(AboutMeDto aboutMeDTO) {
        aboutMeRepository.delete(AboutMeMapper.INSTANCE.toEntity(aboutMeDTO));
    }
}
