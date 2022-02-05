package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceDetails;
import ru.dpopkov.knownics.dto.SourceDetailsDto;

@Component
public class SourceDetailsToDto implements Converter<SourceDetails, SourceDetailsDto> {
    @Override
    public SourceDetailsDto convert(SourceDetails sourceDetails) {
        SourceDetailsDto dto = new SourceDetailsDto();
        dto.setId(sourceDetails.getId());
        dto.setCreatedOn(sourceDetails.getCreatedOn());
        dto.setModifiedOn(sourceDetails.getModifiedOn());
        Source source = sourceDetails.getSource();
        dto.setSourceTitle(source.getTitle());
        dto.setSourceType(source.getType().toString());
        dto.setSourceUrl(source.getUrl());
        dto.setDetails(sourceDetails.getDetails());
        return dto;
    }
}
