package com.kittyvt.restapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AboutMeDTO {
    String language;
    String title;
    String description;
}
