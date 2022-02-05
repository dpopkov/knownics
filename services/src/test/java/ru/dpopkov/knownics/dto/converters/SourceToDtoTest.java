package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceType;
import ru.dpopkov.knownics.dto.SourceDto;

import static org.junit.jupiter.api.Assertions.*;

class SourceToDtoTest {

    final SourceToDto toDto = new SourceToDto();

    @Test
    void testConvert() {
        // Given
        Source source = new Source("Title", "Full title", SourceType.BOOK, "url", "description");
        // When
        SourceDto dto = toDto.convert(source);
        // Then
        assertNotNull(dto);
        assertEquals(source.getId(), dto.getId());
        assertEquals(source.getCreatedOn(), dto.getCreatedOn());
        assertEquals(source.getModifiedOn(), dto.getModifiedOn());
        assertEquals(source.getTitle(), dto.getTitle());
        assertEquals(source.getFullTitle(), dto.getFullTitle());
        assertEquals(source.getType().toString(), dto.getType());
        assertEquals(source.getUrl(), dto.getUrl());
        assertEquals(source.getDescription(), dto.getDescription());
    }
}
