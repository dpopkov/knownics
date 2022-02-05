package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.dto.AnswerDto;
import ru.dpopkov.knownics.dto.QuestionDto;

@Component
public class QuestionToDto implements Converter<Question, QuestionDto> {
    private final CategoryToDto categoryToDto;
    private final TranslationToDto translationToDto;
    private final AnswerToDto answerToDto;
    private final KeyTermToDto keyTermToDto;

    public QuestionToDto(CategoryToDto categoryToDto, TranslationToDto translationToDto, AnswerToDto answerToDto, KeyTermToDto keyTermToDto) {
        this.categoryToDto = categoryToDto;
        this.translationToDto = translationToDto;
        this.answerToDto = answerToDto;
        this.keyTermToDto = keyTermToDto;
    }

    @Override
    public QuestionDto convert(Question source) {
        QuestionDto dto = new QuestionDto();
        dto.setId(source.getId());
        dto.setCreatedOn(source.getCreatedOn());
        dto.setModifiedOn(source.getModifiedOn());
        dto.setCategory(categoryToDto.convert(source.getCategory()));
        source.getTranslations().forEach((key, value) -> dto.addTranslation(translationToDto.convert(value)));
        source.getAnswers().forEach(answer -> {
            AnswerDto answerDto = answerToDto.convert(answer);
            dto.addAnswer(answerDto);
        });
        source.getKeyTerms().forEach(keyTerm -> dto.getKeyTerms().add(keyTermToDto.convert(keyTerm)));
        dto.setComment(source.getComment());
        return dto;
    }
}
