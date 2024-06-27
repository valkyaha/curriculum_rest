package com.kittyvt.restapi.domain.dao.impl;

import com.kittyvt.restapi.domain.AboutMe;
import com.kittyvt.restapi.domain.dao.DAO;
import com.kittyvt.restapi.domain.dto.AboutMeRecord;
import com.kittyvt.restapi.domain.mapper.AboutMeMapper;
import com.kittyvt.restapi.repository.AboutMeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class AboutMeDAO implements DAO<AboutMeRecord> {

    private final AboutMeRepository aboutMeRepository;

    public AboutMeDAO(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    @Override
    public Optional<AboutMeRecord> get(String language) {
        return aboutMeRepository.findByLanguage(language).map(AboutMeMapper.INSTANCE::toRecord);
    }

    @Override
    public List<AboutMeRecord> getAll(String language) {
        return List.of();
    }

    @Override
    public void save(AboutMeRecord aboutMeRecord) {
    }

    @Override
    public void update(AboutMeRecord aboutMeRecord) {

    }

    @Override
    public void delete(AboutMeRecord aboutMeRecord) {

    }
}
