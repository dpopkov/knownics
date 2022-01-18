package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.dto.CategoryDto;

@Component
public class CategoryToDto implements Converter<Category, CategoryDto> {
    @Override
    public CategoryDto convert(Category source) {
        CategoryDto dto = new CategoryDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setDescription(source.getDescription());
        dto.setCreatedOn(source.getCreatedOn());
        dto.setModifiedOn(source.getModifiedOn());
        return dto;
    }
}
