package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.answer.*;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.dto.AnswerDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AnswerToDtoTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    final AnswerToDto toDto = new AnswerToDto(new TranslationToDto(), new SourceDetailsToDto());

    @Test
    void testConvert() {
        // Given
        Answer answer = new Answer();
        answer.setId(123L);
        answer.setCreatedOn(NOW);
        answer.setModifiedOn(NOW);
        answer.setQuestion(new Question());
        answer.setType(AnswerType.ORIGINAL);
        answer.addTranslation(new AnswerText(Language.EN, "Test translation"));
        SourceDetails sourceDetails = new SourceDetails(
                new Source("Core Java", SourceType.BOOK), "page 123");
        answer.setSourceDetails(sourceDetails);
        answer.setComment("test comment");
        // When
        final AnswerDto dto = toDto.convert(answer);
        // Then
        assertNotNull(dto);
        assertEquals(answer.getId(), dto.getId());
        assertEquals(answer.getCreatedOn(), dto.getCreatedOn());
        assertEquals(answer.getModifiedOn(), dto.getModifiedOn());
        assertEquals(answer.getType().toString(), dto.getType());
        assertEquals(answer.getTranslations().size(), dto.getTranslations().size());
        assertEquals(answer.getTranslations().get(Language.EN).getText(), dto.getTranslations().get("EN").getText());
        assertEquals(answer.getSourceDetails().getSource().getTitle(), dto.getSourceDetails().getSourceTitle());
        assertEquals(answer.getSourceDetails().getDetails(), dto.getSourceDetails().getDetails());
        assertEquals(answer.getComment(), dto.getComment());
    }
}
