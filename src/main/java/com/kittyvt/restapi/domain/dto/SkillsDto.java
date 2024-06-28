package com.kittyvt.restapi.domain.dto;

import java.io.Serializable;

public record SkillsDto(Long id, String skillName, String description, String language) implements Serializable {
}