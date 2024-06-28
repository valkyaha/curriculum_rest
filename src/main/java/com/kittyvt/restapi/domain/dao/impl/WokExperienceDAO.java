package com.kittyvt.restapi.domain.dao.impl;


import com.kittyvt.restapi.domain.dao.DAO;
import com.kittyvt.restapi.domain.dto.WorkExperienceDto;

import java.util.Optional;

public class WokExperienceDAO implements DAO<WorkExperienceDto> {
    @Override
    public Optional<WorkExperienceDto> get(String language) {
        return Optional.empty();
    }

    @Override
    public void save(WorkExperienceDto workExperienceDTO) {
        //WIP
    }

    @Override
    public void update(String language, WorkExperienceDto after) {
        //WIP
    }

    @Override
    public void delete(WorkExperienceDto workExperienceDTO) {
        //WIP
    }
}
