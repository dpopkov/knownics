package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import ru.dpopkov.knownics.domain.question.QCollection;
import ru.dpopkov.knownics.domain.question.QCollectionRepository;

@Profile(Profiles.REPOSITORY_MAP)
public class QCollectionMapRepository extends AbstractMapRepository<QCollection> implements QCollectionRepository {
}
