package ru.dpopkov.knownics.services;

import ru.dpopkov.knownics.domain.BaseEntity;
import ru.dpopkov.knownics.domain.BaseRepository;

import java.util.Optional;

public class AbstractService<T extends BaseEntity> implements BaseService<T> {
    private final BaseRepository<T> repository;

    public AbstractService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> objects) {
        return repository.saveAll(objects);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public long count() {
        return repository.count();
    }
}
