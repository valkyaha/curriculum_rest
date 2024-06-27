package com.kittyvt.restapi.domain.dao.impl;

import com.kittyvt.restapi.domain.AboutMe;
import com.kittyvt.restapi.domain.dao.DAO;
import com.kittyvt.restapi.domain.dto.AboutMeDTO;
import com.kittyvt.restapi.domain.mapper.AboutMeMapper;
import com.kittyvt.restapi.repository.AboutMeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class AboutMeDAO implements DAO<AboutMeDTO> {

    private final AboutMeRepository aboutMeRepository;

    public AboutMeDAO(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    @Override
    public Optional<AboutMeDTO> get(String language) {
        return aboutMeRepository.findByLanguage(language).map(AboutMeMapper.INSTANCE::toRecord);
    }

    @Override
    public List<AboutMeDTO> getAll(String language) {
        return List.of();
    }

    @Override
    public void save(AboutMeDTO aboutMeDTO) {
        aboutMeRepository.save(AboutMeMapper.INSTANCE.toEntity(aboutMeDTO));
    }

    @Override
    public void update(String lang, AboutMeDTO after) {
        Optional<AboutMe> before = aboutMeRepository.findByLanguage(lang);
        before.ifPresent(update -> {
            update.setDescription(after.getDescription());
            update.setTitle(after.getTitle());
            aboutMeRepository.save(update);
        });
    }

    @Override
    public void delete(AboutMeDTO aboutMeDTO) {
        aboutMeRepository.delete(AboutMeMapper.INSTANCE.toEntity(aboutMeDTO));
    }
}
