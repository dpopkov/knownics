package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.dto.KeyTermDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class KeyTermToDtoTest {

    private static final long ID = 12L;
    private static final LocalDateTime CREATED_ON = LocalDateTime.now();
    private static final LocalDateTime MODIFIED_ON = LocalDateTime.now();
    private static final String NAME = "James";
    private static final String DESCRIPTION = "test";

    private final KeyTermToDto toDto = new KeyTermToDto();

    @Test
    void testConvert() {
        KeyTerm keyTerm = new KeyTerm();
        keyTerm.setId(ID);
        keyTerm.setCreatedOn(CREATED_ON);
        keyTerm.setModifiedOn(MODIFIED_ON);
        keyTerm.setName(NAME);
        keyTerm.setDescription(DESCRIPTION);

        KeyTermDto dto = toDto.convert(keyTerm);

        assertNotNull(dto);
        assertEquals(keyTerm.getId(), dto.getId());
        assertEquals(keyTerm.getCreatedOn(), dto.getCreatedOn());
        assertEquals(keyTerm.getModifiedOn(), dto.getModifiedOn());
        assertEquals(keyTerm.getName(), dto.getName());
        assertEquals(keyTerm.getDescription(), dto.getDescription());
    }
}
