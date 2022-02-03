package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.question.QuestionText;
import ru.dpopkov.knownics.dto.TranslationDto;

@Component
public class DtoToQuestionText extends DtoToTranslation<QuestionText>
                               implements Converter<TranslationDto, QuestionText> {

    public DtoToQuestionText() {
        super(QuestionText::new);
    }
}
