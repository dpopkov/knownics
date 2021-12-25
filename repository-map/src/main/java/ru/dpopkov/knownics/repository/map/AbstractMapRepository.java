package ru.dpopkov.knownics.repository.map;

import ru.dpopkov.knownics.domain.BaseEntity;
import ru.dpopkov.knownics.domain.BaseRepository;

import java.util.*;

public abstract class AbstractMapRepository<T extends BaseEntity> implements BaseRepository<T> {
    protected final Map<Long, T> map = new HashMap<>();

    @Override
    public T save(T object) {
        Long id = nextId();
        object.setId(id);
        map.put(id, object);
        return object;
    }

    private Long nextId() {
        if (map.isEmpty()) {
            return 1L;
        }
        return Collections.max(map.keySet()) + 1;
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> objects) {
        List<T> all = new ArrayList<>();
        for (T object : objects) {
            T saved = save(object);
            all.add(saved);
        }
        return all;
    }

    @Override
    public Iterable<T> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void deleteById(Long id) {
        T removed = map.remove(id);
        if (removed != null) {
            removed.setId(null);
        }
    }

    @Override
    public void delete(T object) {
        if (object.getId() == null) {
            throw new IllegalArgumentException("Entity ID is null");
        }
        deleteById(object.getId());
    }

    @Override
    public void deleteAll() {
        map.clear();
    }

    @Override
    public long count() {
        return map.size();
    }
}
