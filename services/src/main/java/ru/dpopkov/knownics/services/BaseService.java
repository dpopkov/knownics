package ru.dpopkov.knownics.services;

import ru.dpopkov.knownics.domain.HavingId;

import java.util.Optional;

public interface BaseService<T extends HavingId>  {

    T save(T object);
    Iterable<T> saveAll(Iterable<T> objects);
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
    void delete(T object);
    void deleteAll();
    long count();
}
