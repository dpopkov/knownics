package ru.dpopkov.knownics.services;

import org.springframework.stereotype.Service;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;
import ru.dpopkov.knownics.dto.CategoryDto;
import ru.dpopkov.knownics.dto.converters.CategoryToDto;
import ru.dpopkov.knownics.dto.converters.DtoToCategory;

@Service
public class CategoryServiceImpl extends AbstractDtoService<Category, CategoryDto> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository,
                               CategoryToDto toDtoConverter, DtoToCategory fromDtoConverter) {
        super(repository, toDtoConverter, fromDtoConverter);
    }
}
