package com.kittyvt.restapi.domain.mapper;

import com.kittyvt.restapi.domain.AboutMe;
import com.kittyvt.restapi.domain.dto.AboutMeDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AboutMeMapper {
    AboutMeMapper INSTANCE = Mappers.getMapper(AboutMeMapper.class);

    AboutMeDto toRecord(AboutMe aboutMe);

    AboutMe toEntity(AboutMeDto aboutMeDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AboutMe partialUpdate(AboutMeDto aboutMeDto, @MappingTarget AboutMe aboutMe);
}