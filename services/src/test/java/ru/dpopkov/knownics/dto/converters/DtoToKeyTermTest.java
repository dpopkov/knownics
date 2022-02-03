package ru.dpopkov.knownics.dto.converters;

import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.dto.KeyTermDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DtoToKeyTermTest {

    private static final long ID = 12L;
    private static final LocalDateTime CREATED_ON = LocalDateTime.now();
    private static final LocalDateTime MODIFIED_ON = LocalDateTime.now();
    private static final String NAME = "James";
    private static final String DESCRIPTION = "test";

    private final DtoToKeyTerm toKeyTerm = new DtoToKeyTerm();

    @Test
    void testConvert() {
        KeyTermDto dto = new KeyTermDto();
        dto.setId(ID);
        dto.setCreatedOn(CREATED_ON);
        dto.setModifiedOn(MODIFIED_ON);
        dto.setName(NAME);
        dto.setDescription(DESCRIPTION);

        KeyTerm keyTerm = toKeyTerm.convert(dto);

        assertNotNull(keyTerm);
        assertEquals(dto.getId(), keyTerm.getId());
        assertEquals(dto.getName(), keyTerm.getName());
        assertEquals(dto.getDescription(), keyTerm.getDescription());
        /*
            Timestamp fields in entities will be handled by Hibernate automatically.
         */
        assertNull(keyTerm.getCreatedOn());
        assertNull(keyTerm.getModifiedOn());
    }
}
