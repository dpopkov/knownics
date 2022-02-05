package ru.dpopkov.knownics.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceRepository;

@Profile(Profiles.REPOSITORY_JPA)
public interface SourceJpaRepository extends CrudRepository<Source, Long>, SourceRepository {
}
