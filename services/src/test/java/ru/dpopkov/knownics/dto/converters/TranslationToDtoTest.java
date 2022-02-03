package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.AbstractTranslation;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.TextType;
import ru.dpopkov.knownics.domain.question.QuestionText;
import ru.dpopkov.knownics.dto.TranslationDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TranslationToDtoTest {

    public static final LocalDateTime CREATED_ON = LocalDateTime.now();
    public static final LocalDateTime MODIFIED_ON = LocalDateTime.now();
    public static final Language LANGUAGE = Language.EN;
    public static final TextType TEXT_TYPE = TextType.PLAINTEXT;
    public static final String TEXT = "Text of translation";

    private final TranslationToDto toDto = new TranslationToDto();

    @Test
    void testConvert() {
        AbstractTranslation translation = new QuestionText();
        translation.setCreatedOn(CREATED_ON);
        translation.setModifiedOn(MODIFIED_ON);
        translation.setLanguage(LANGUAGE);
        translation.setType(TEXT_TYPE);
        translation.setText(TEXT);

        TranslationDto dto = toDto.convert(translation);

        assertNotNull(dto);
        assertEquals(translation.getCreatedOn(), dto.getCreatedOn());
        assertEquals(translation.getModifiedOn(), dto.getModifiedOn());
        assertEquals(translation.getLanguage().toString(), dto.getLanguage());
        assertEquals(translation.getType().toString(), dto.getType());
        assertEquals(translation.getText(), dto.getText());
        /*
            DTO for embedded objects do not use Id.
         */
        assertNull(dto.getId());
    }
}
