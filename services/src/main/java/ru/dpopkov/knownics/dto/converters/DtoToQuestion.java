package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.dto.QuestionDto;

@Component
public class DtoToQuestion implements Converter<QuestionDto, Question> {
    @Override
    public Question convert(QuestionDto source) {
        throw new RuntimeException("Not implemented yet");
    }
}
