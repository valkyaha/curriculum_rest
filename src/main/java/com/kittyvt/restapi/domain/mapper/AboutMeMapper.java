package com.kittyvt.restapi.domain.mapper;

import com.kittyvt.restapi.domain.AboutMe;
import com.kittyvt.restapi.domain.dto.AboutMeRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AboutMeMapper {

    AboutMeMapper INSTANCE = Mappers.getMapper(AboutMeMapper.class);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "language", source = "language")
    AboutMeRecord toRecord(AboutMe aboutMe);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "language", source = "language")
    AboutMe toEntity(AboutMeRecord aboutMeRecord);
}

