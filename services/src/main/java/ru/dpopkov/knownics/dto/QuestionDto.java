package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class QuestionDto extends ModifiableDto {

    @NotNull
    private CategoryDto category;
    private Map<String, TranslationDto> translations = new HashMap<>();
    private Set<AnswerDto> answers = new HashSet<>();
    private Long preferredAnswerId;
    private Set<KeyTermDto> keyTerms = new HashSet<>();
    private String comment;

    public void addTranslation(TranslationDto translationDto) {
        translations.put(translationDto.getLanguage(), translationDto);
    }

    public void addAnswer(AnswerDto answerDto) {
        answers.add(answerDto);
    }
}
