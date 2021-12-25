package ru.dpopkov.knownics.repository.map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.KeyTermRepository;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceDetails;
import ru.dpopkov.knownics.domain.answer.SourceDetailsRepository;
import ru.dpopkov.knownics.domain.user.AppUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AnswerMapRepositoryTest {
    @Mock
    SourceDetailsRepository sourceDetailsRepository;
    @Mock
    KeyTermRepository keyTermRepository;
    @InjectMocks
    AnswerMapRepository answerMapRepository;

    @Test
    void testSave() {
        // Given
        Answer answer = new Answer();
        SourceDetails details = new SourceDetails(new Source("source"), "details");
        answer.setSourceDetails(details);
        KeyTerm keyTerm = new KeyTerm("Test", "desc");
        answer.addKeyTerm(keyTerm);
        AppUser author = new AppUser("Author");
        author.setId(123L);
        AppUser editor = new AppUser("Editor");
        editor.setId(124L);
        answer.setCreatedBy(author);
        answer.setModifiedBy(editor);
        // When
        answerMapRepository.save(answer);
        // Then
        then(sourceDetailsRepository).should().save(any(SourceDetails.class));
        then(keyTermRepository).should().save(any(KeyTerm.class));
        assertThat(answer.getId()).isNotNull();
    }
}
