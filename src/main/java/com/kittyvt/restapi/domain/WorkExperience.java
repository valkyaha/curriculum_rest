package com.kittyvt.restapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "work_expercience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String language;

    @Column
    private String jobTitle;

    @Column
    private String description;

    @OneToMany(mappedBy = "workExperience", orphanRemoval = true)
    private Set<Skills> skills = new LinkedHashSet<>();

}