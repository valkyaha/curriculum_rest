package com.kittyvt.restapi.repository;

import com.kittyvt.restapi.domain.Skills;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skills, Long> {
}