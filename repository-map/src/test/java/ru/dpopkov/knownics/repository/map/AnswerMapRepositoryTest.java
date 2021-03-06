package ru.dpopkov.knownics.repository.map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.KeyTermRepository;
import ru.dpopkov.knownics.domain.answer.*;
import ru.dpopkov.knownics.domain.user.AppUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AnswerMapRepositoryTest {
    @Mock
    SourceDetailsRepository sourceDetailsRepository;
    @Mock
    KeyTermRepository keyTermRepository;
    @InjectMocks
    AnswerMapRepository answerMapRepository;
    @Captor
    ArgumentCaptor<KeyTerm> keyTermCaptor;
    @Captor
    ArgumentCaptor<SourceDetails> sourceDetailsCaptor;

    @Test
    void testSave() {
        // Given
        Answer answer = new Answer();
        SourceDetails details = new SourceDetails(new Source("Spring in Action", SourceType.BOOK), "details");
        answer.setSourceDetails(details);
        KeyTerm keyTerm = new KeyTerm("Spring", "desc");
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
        then(sourceDetailsRepository).should().save(sourceDetailsCaptor.capture());
        then(keyTermRepository).should().save(keyTermCaptor.capture());
        assertThat(sourceDetailsCaptor.getValue().getSource().getTitle()).isEqualTo("Spring in Action");
        assertThat(keyTermCaptor.getValue().getName()).isEqualTo("Spring");
        assertThat(answer.getId()).isNotNull();
    }
}
