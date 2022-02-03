package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.dto.KeyTermDto;

@Component
public class DtoToKeyTerm implements Converter<KeyTermDto, KeyTerm> {
    @Override
    public KeyTerm convert(KeyTermDto source) {
        KeyTerm keyTerm = new KeyTerm();
        keyTerm.setId(source.getId());
        keyTerm.setName(source.getName());
        keyTerm.setDescription(source.getDescription());
        return keyTerm;
    }
}
