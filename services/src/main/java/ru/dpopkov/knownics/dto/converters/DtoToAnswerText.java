package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.answer.AnswerText;
import ru.dpopkov.knownics.dto.TranslationDto;

@Component
public class DtoToAnswerText extends DtoToTranslation<AnswerText>
                               implements Converter<TranslationDto, AnswerText> {

    public DtoToAnswerText() {
        super(AnswerText::new);
    }
}
