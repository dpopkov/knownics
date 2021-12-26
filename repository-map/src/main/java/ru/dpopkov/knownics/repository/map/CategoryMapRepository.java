package ru.dpopkov.knownics.repository.map;

import org.springframework.stereotype.Repository;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

@Repository
public class CategoryMapRepository extends AbstractMapRepository<Category> implements CategoryRepository {
}
