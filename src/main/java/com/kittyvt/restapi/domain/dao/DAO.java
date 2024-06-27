package com.kittyvt.restapi.domain.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(String Language);

    List<T> getAll(String language);

    void save(T t);

    void update(String language, T after);

    void delete(T t);
}
