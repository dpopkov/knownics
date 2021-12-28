package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

@Repository
@Profile(Profiles.REPOSITORY_MAP)
public class CategoryMapRepository extends AbstractMapRepository<Category> implements CategoryRepository {
}
