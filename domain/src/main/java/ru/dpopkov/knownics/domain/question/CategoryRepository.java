package ru.dpopkov.knownics.domain.question;

import ru.dpopkov.knownics.domain.BaseRepository;

import java.util.Optional;

public interface CategoryRepository extends BaseRepository<Category> {

    Optional<Category> findByDescription(String description);
}
