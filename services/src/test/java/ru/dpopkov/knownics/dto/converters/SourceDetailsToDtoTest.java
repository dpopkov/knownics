package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceDetails;
import ru.dpopkov.knownics.domain.answer.SourceType;
import ru.dpopkov.knownics.dto.SourceDetailsDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SourceDetailsToDtoTest {

    private static final LocalDateTime NOW = LocalDateTime.now();

    final SourceDetailsToDto toDto = new SourceDetailsToDto();

    @Test
    void testConvert() {
        // Given
        Source coreJava = new Source("Core Java 11e", "Core Java, 11th Edition", SourceType.BOOK,
                "url", "description");
        SourceDetails sourceDetails = new SourceDetails(coreJava, "page 123");
        sourceDetails.setId(123L);
        sourceDetails.setCreatedOn(NOW);
        sourceDetails.setModifiedOn(NOW);
        // When
        final SourceDetailsDto dto = toDto.convert(sourceDetails);
        // Then
        assertNotNull(dto);
        assertEquals(sourceDetails.getId(), dto.getId());
        assertEquals(sourceDetails.getCreatedOn(), dto.getCreatedOn());
        assertEquals(sourceDetails.getModifiedOn(), dto.getModifiedOn());
        assertEquals(sourceDetails.getSource().getTitle(), dto.getSourceTitle());
        assertEquals(sourceDetails.getSource().getType().toString(), dto.getSourceType());
        assertEquals(sourceDetails.getSource().getUrl(), dto.getSourceUrl());
        assertEquals(sourceDetails.getDetails(), dto.getDetails());
    }
}
