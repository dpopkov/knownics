package ru.dpopkov.knownics.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionRepository;
import ru.dpopkov.knownics.dto.QuestionDto;
import ru.dpopkov.knownics.dto.converters.DtoToQuestion;
import ru.dpopkov.knownics.dto.converters.QuestionToDto;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {
    @Mock
    QuestionRepository repository;
    @Mock
    QuestionToDto toDto;
    @Mock
    DtoToQuestion toQuestion;
    @InjectMocks
    QuestionServiceImpl service;

    @Test
    void testFindAll() {
        // Given
        List<Question> questions = List.of(new Question(), new Question());
        given(repository.findAll()).willReturn(questions);
        given(toDto.convert(any())).willReturn(new QuestionDto());
        // When
        final Collection<QuestionDto> all = service.findAll();
        // Then
        assertEquals(2, all.size());
        then(repository).should().findAll();
    }
}
