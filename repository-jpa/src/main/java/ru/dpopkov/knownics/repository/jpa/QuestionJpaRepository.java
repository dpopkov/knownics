package ru.dpopkov.knownics.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionRepository;

import java.util.Optional;

public interface QuestionJpaRepository extends CrudRepository<Question, Long>, QuestionRepository {

    @Override
    <S extends Question> S save(S entity);

    @Override
    Optional<Question> findById(Long aLong);
}
