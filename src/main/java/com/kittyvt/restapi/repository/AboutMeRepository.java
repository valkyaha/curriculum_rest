package com.kittyvt.restapi.repository;

import com.kittyvt.restapi.domain.AboutMe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AboutMeRepository extends CrudRepository<AboutMe, Long> {
    Optional<AboutMe> findByLanguage(String language);
}
