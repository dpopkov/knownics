package ru.dpopkov.knownics.services;

import ru.dpopkov.knownics.domain.HavingId;

import java.util.Collection;
import java.util.Optional;

public interface BaseService<T extends HavingId>  {

    T save(T object);
    Collection<T> saveAll(Collection<T> objects);
    Collection<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
    void delete(T object);
    void deleteAll();
    long count();
}
