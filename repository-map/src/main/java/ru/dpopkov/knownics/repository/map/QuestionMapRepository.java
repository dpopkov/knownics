package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionRepository;

@Profile(Profiles.REPOSITORY_MAP)
public class QuestionMapRepository extends AbstractMapRepository<Question> implements QuestionRepository {
}
