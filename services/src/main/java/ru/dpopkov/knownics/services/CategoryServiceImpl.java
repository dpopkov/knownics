package ru.dpopkov.knownics.services;

import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}
