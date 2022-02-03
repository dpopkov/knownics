package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import ru.dpopkov.knownics.domain.AbstractTranslation;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.TextType;
import ru.dpopkov.knownics.dto.TranslationDto;

import java.util.function.Supplier;

public abstract class DtoToTranslation<E extends AbstractTranslation> implements Converter<TranslationDto, E> {

    private final Supplier<E> constructor;

    public DtoToTranslation(Supplier<E> constructor) {
        this.constructor = constructor;
    }

    @Override
    public E convert(TranslationDto source) {
        E translation = constructor.get();
        translation.setLanguage(Language.valueOf(source.getLanguage().toUpperCase()));
        translation.setType(TextType.valueOf(source.getType().toUpperCase()));
        translation.setText(source.getText());
        return translation;
    }
}
