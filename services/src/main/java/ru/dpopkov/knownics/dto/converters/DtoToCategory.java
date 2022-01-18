package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.dto.CategoryDto;

@Component
public class DtoToCategory implements Converter<CategoryDto, Category> {
    @Override
    public Category convert(CategoryDto source) {
        Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getName());
        category.setDescription(source.getDescription());
        return category;
    }
}
