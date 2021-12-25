package ru.dpopkov.knownics.repository.map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceDetails;
import ru.dpopkov.knownics.domain.answer.SourceRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class SourceDetailsMapRepositoryTest {
    @Mock
    SourceRepository sourceRepository;
    @InjectMocks
    SourceDetailsMapRepository sourceDetailsMapRepository;

    @Test
    void testSave() {
        // Given
        Source source = new Source("source-1");
        SourceDetails sourceDetails = new SourceDetails(source, "details");
        // When
        sourceDetailsMapRepository.save(sourceDetails);
        // Then
        then(sourceRepository).should().save(any(Source.class));
        assertThat(sourceDetails.getId()).isNotNull();
    }
}
