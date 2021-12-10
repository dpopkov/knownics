package ru.dpopkov.knownics.domain;

import java.util.Optional;

public interface BaseRepository<T extends BaseEntity> {

    <S extends T> S save(T object);
    <S extends T> Iterable<S> saveAll(Iterable<T> objects);
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
    void delete(T object);
    void deleteAll();
}
