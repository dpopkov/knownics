package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.dto.SourceDto;

@Component
public class SourceToDto implements Converter<Source, SourceDto> {
    @Override
    public SourceDto convert(Source source) {
        SourceDto dto = new SourceDto();
        dto.setId(source.getId());
        dto.setCreatedOn(source.getCreatedOn());
        dto.setModifiedOn(source.getModifiedOn());
        dto.setTitle(source.getTitle());
        dto.setFullTitle(source.getFullTitle());
        dto.setType(source.getType().toString());
        dto.setUrl(source.getUrl());
        dto.setDescription(source.getDescription());
        return dto;
    }
}
