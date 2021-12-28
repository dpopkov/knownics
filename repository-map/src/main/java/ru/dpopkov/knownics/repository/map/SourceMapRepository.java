package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceRepository;

@Profile(Profiles.REPOSITORY_MAP)
public class SourceMapRepository extends AbstractMapRepository<Source> implements SourceRepository {
}
