package ru.dpopkov.knownics.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

import java.util.Optional;

@Profile(Profiles.REPOSITORY_JPA)
public interface CategoryJpaRepository  extends CrudRepository<Category, Long>, CategoryRepository {

    @Override
    <S extends Category> S save(S entity);

    @Override
    Optional<Category> findById(Long aLong);
}
