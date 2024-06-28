package com.kittyvt.restapi.domain.mapper;

import com.kittyvt.restapi.domain.Skills;
import com.kittyvt.restapi.domain.dto.SkillsDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SkillsMapper {
    Skills toEntity(SkillsDto skillsDto);

    SkillsDto toDto(Skills skills);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Skills partialUpdate(SkillsDto skillsDto, @MappingTarget Skills skills);
}