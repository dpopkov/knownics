package ru.dpopkov.knownics.services;

import org.springframework.stereotype.Service;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

@Service
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}
