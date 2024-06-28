package com.kittyvt.restapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String skillName;

    @Column
    private String description;

    @Column
    private String language;

    @ManyToOne
    @JoinColumn(name = "work_experience_id")
    private WorkExperience workExperience;
}