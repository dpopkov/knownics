package ru.dpopkov.knownics.services;

import org.springframework.stereotype.Service;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionRepository;
import ru.dpopkov.knownics.dto.QuestionDto;
import ru.dpopkov.knownics.dto.converters.DtoToQuestion;
import ru.dpopkov.knownics.dto.converters.QuestionToDto;

@Service
public class QuestionServiceImpl extends AbstractDtoService<Question, QuestionDto> implements QuestionService {

    public QuestionServiceImpl(QuestionRepository repository, QuestionToDto toDto, DtoToQuestion toQuestion) {
        super(repository, toDto, toQuestion);
    }
}
