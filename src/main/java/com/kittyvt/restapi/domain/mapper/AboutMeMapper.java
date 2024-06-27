package com.kittyvt.restapi.domain.mapper;

import com.kittyvt.restapi.domain.AboutMe;
import com.kittyvt.restapi.domain.dto.AboutMeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AboutMeMapper {

    AboutMeMapper INSTANCE = Mappers.getMapper(AboutMeMapper.class);


    @Mapping(target = "language", source = "language")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    AboutMeDTO toRecord(AboutMe aboutMe);


    @Mapping(target = "language", source = "language")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    AboutMe toEntity(AboutMeDTO aboutMeDTO);
}

