package ru.dpopkov.knownics.domain;

import java.util.Optional;

public interface BaseRepository<T extends BaseEntity> {

    T save(T object);
    Iterable<T> saveAll(Iterable<T> objects);
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
    void delete(T object);
    void deleteAll();
    long count();
}
