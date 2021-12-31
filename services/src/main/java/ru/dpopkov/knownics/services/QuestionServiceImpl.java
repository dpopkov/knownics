package ru.dpopkov.knownics.services;

import org.springframework.stereotype.Service;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionRepository;

@Service
public class QuestionServiceImpl extends AbstractService<Question> implements QuestionService {

    public QuestionServiceImpl(QuestionRepository repository) {
        super(repository);
    }
}
