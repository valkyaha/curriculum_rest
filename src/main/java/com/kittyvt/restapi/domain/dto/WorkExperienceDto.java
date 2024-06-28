package com.kittyvt.restapi.domain.dto;

import java.io.Serializable;
import java.util.Set;

public record WorkExperienceDto(Long id, String language, String jobTitle, String description,
                                Set<SkillsDto> skills) implements Serializable {
}