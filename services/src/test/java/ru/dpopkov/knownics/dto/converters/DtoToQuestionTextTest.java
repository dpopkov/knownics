package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.TextType;
import ru.dpopkov.knownics.domain.question.QuestionText;
import ru.dpopkov.knownics.dto.TranslationDto;

import static org.junit.jupiter.api.Assertions.*;

class DtoToQuestionTextTest {

    final DtoToQuestionText toQuestionText = new DtoToQuestionText();

    @Test
    void testConvert() {
        TranslationDto dto = new TranslationDto();
        dto.setLanguage("en");
        dto.setType("plaintext");
        dto.setText("Spring in Action");

        QuestionText questionText = toQuestionText.convert(dto);

        assertNotNull(questionText);
        assertEquals(Language.EN, questionText.getLanguage());
        assertEquals(TextType.PLAINTEXT, questionText.getType());
        assertEquals(dto.getText(), questionText.getText());
    }
}
