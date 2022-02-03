package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.dto.KeyTermDto;

@Component
public class KeyTermToDto implements Converter<KeyTerm, KeyTermDto> {
    @Override
    public KeyTermDto convert(KeyTerm source) {
        KeyTermDto dto = new KeyTermDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setDescription(source.getDescription());
        dto.setCreatedOn(source.getCreatedOn());
        dto.setModifiedOn(source.getModifiedOn());
        return dto;
    }
}
