package ru.dpopkov.knownics.domain;

import java.util.Optional;

public interface BaseRepository<T extends BaseEntity> {

    <S extends T> S save(S object);
    <S extends T> Iterable<S> saveAll(Iterable<S> objects);
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
    void delete(T object);
    void deleteAll();
    long count();
}
