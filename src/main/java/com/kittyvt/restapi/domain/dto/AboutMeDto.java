package com.kittyvt.restapi.domain.dto;

import java.io.Serializable;

public record AboutMeDto(String language, String title, String description) implements Serializable {
}