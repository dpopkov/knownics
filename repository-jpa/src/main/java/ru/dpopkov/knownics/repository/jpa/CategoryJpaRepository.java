package ru.dpopkov.knownics.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

@Profile(Profiles.REPOSITORY_JPA)
public interface CategoryJpaRepository  extends CrudRepository<Category, Long>, CategoryRepository {
}
