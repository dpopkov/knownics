package ru.dpopkov.knownics.services;

import org.springframework.core.convert.converter.Converter;
import ru.dpopkov.knownics.domain.BaseEntity;
import ru.dpopkov.knownics.domain.BaseRepository;
import ru.dpopkov.knownics.dto.BaseDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDtoService<T extends BaseEntity, U extends BaseDto> implements BaseService<U> {
    private final BaseRepository<T> repository;
    private final Converter<T, U> toDtoConverter;
    private final Converter<U, T> fromDtoConverter;

    public AbstractDtoService(BaseRepository<T> repository,
                              Converter<T, U> toDtoConverter, Converter<U, T> fromDtoConverter) {
        this.repository = repository;
        this.toDtoConverter = toDtoConverter;
        this.fromDtoConverter = fromDtoConverter;
    }

    @Override
    public U save(U object) {
        T entity = fromDtoConverter.convert(object);
        T saved = repository.save(entity);
        return toDtoConverter.convert(saved);
    }

    @Override
    public Collection<U> saveAll(Collection<U> objects) {
        List<T> toSave = new ArrayList<>();
        objects.forEach(dto -> toSave.add(fromDtoConverter.convert(dto)));
        Iterable<T> saved = repository.saveAll(toSave);
        List<U> result = new ArrayList<>();
        saved.forEach(entity -> result.add(toDtoConverter.convert(entity)));
        return result;
    }

    @Override
    public Collection<U> findAll() {
        List<U> result = new ArrayList<>();
        repository.findAll().forEach(entity -> result.add(toDtoConverter.convert(entity)));
        return result;
    }

    @Override
    public Optional<U> findById(Long id) {
        return repository.findById(id).map(toDtoConverter::convert);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(U object) {
        repository.deleteById(object.getId());
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
