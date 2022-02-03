package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.TextType;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionText;
import ru.dpopkov.knownics.dto.QuestionDto;
import ru.dpopkov.knownics.dto.TranslationDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class QuestionToDtoTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    final QuestionToDto toDto = new QuestionToDto(new CategoryToDto(), new TranslationToDto(), new KeyTermToDto());

    @Test
    void testConvert() {
        Question question = new Question();
        question.setId(10L);
        question.setCreatedOn(NOW);
        question.setModifiedOn(NOW);
        final Category category = new Category("Java", "Java language");
        category.setId(11L);
        question.setCategory(category);
        QuestionText questionText = new QuestionText(Language.EN, TextType.PLAINTEXT, "What is Java");
        question.addTranslation(questionText);
        final Answer answer = new Answer();
        answer.setId(12L);
        question.getAnswers().add(answer);
        question.setPreferredAnswer(answer);
        question.getKeyTerms().add(new KeyTerm("Core Java", "Test description"));
        question.setComment("Test comment");

        QuestionDto dto = toDto.convert(question);

        assertNotNull(dto);
        assertEquals(question.getId(), dto.getId());
        assertEquals(question.getCreatedOn(), dto.getCreatedOn());
        assertEquals(question.getModifiedOn(), dto.getModifiedOn());
        assertEquals(question.getCategory().getId(), dto.getCategory().getId());
        assertEquals(question.getCategory().getName(), dto.getCategory().getName());
        assertEquals(question.getCategory().getDescription(), dto.getCategory().getDescription());

        // translations
        assertEquals(question.getTranslations().size(), dto.getTranslations().size());
        final QuestionText questionText1 = question.getTranslations().get(Language.EN);
        final TranslationDto questionTextDto = dto.getTranslations().get("EN");
        assertEquals(questionText1.getType().toString(), questionTextDto.getType());
        assertEquals(questionText1.getText(), questionTextDto.getText());

//        assertEquals(question.getAnswers().size(), dto.getAnswerIds().size());
//        assertEquals(question.getPreferredAnswer().getId(), dto.getPreferredAnswerId());
        assertEquals(question.getKeyTerms().size(), dto.getKeyTerms().size());
        assertEquals(question.getComment(), dto.getComment());
    }
}
