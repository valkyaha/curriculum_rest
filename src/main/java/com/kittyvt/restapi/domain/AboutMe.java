package com.kittyvt.restapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Aboutme")
public class AboutMe {

    @Id
    @Column(name = "language")
    private String language;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
}

