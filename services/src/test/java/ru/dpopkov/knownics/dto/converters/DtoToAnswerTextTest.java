package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.TextType;
import ru.dpopkov.knownics.domain.answer.AnswerText;
import ru.dpopkov.knownics.dto.TranslationDto;

import static org.junit.jupiter.api.Assertions.*;

class DtoToAnswerTextTest {

    final DtoToAnswerText toAnswerText = new DtoToAnswerText();

    @Test
    void testConvert() {
        TranslationDto dto = new TranslationDto();
        dto.setLanguage("en");
        dto.setType("plaintext");
        dto.setText("Spring in Action");

        AnswerText answerText = toAnswerText.convert(dto);

        assertNotNull(answerText);
        assertEquals(Language.EN, answerText.getLanguage());
        assertEquals(TextType.PLAINTEXT, answerText.getType());
        assertEquals(dto.getText(), answerText.getText());
    }
}
