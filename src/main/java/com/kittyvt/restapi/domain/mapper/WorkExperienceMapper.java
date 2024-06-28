package com.kittyvt.restapi.domain.mapper;

import com.kittyvt.restapi.domain.WorkExperience;
import com.kittyvt.restapi.domain.dto.WorkExperienceDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {SkillsMapper.class})
public interface WorkExperienceMapper {
    WorkExperience toEntity(WorkExperienceDto workExperienceDto);

    @AfterMapping
    default void linkSkills(@MappingTarget WorkExperience workExperience) {
        workExperience.getSkills().forEach(skill -> skill.setWorkExperience(workExperience));
    }

    WorkExperienceDto toDto(WorkExperience workExperience);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WorkExperience partialUpdate(WorkExperienceDto workExperienceDto, @MappingTarget WorkExperience workExperience);
}