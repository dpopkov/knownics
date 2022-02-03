package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.AbstractTranslation;
import ru.dpopkov.knownics.dto.TranslationDto;

@Component
public class TranslationToDto implements Converter<AbstractTranslation, TranslationDto> {
    @Override
    public TranslationDto convert(AbstractTranslation source) {
        TranslationDto dto = new TranslationDto();
        dto.setCreatedOn(source.getCreatedOn());
        dto.setModifiedOn(source.getModifiedOn());
        dto.setLanguage(source.getLanguage().toString());
        dto.setType(source.getType().toString());
        dto.setText(source.getText());
        return dto;
    }
}
