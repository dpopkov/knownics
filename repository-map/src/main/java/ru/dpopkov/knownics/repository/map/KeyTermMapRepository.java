package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import ru.dpopkov.knownics.domain.KeyTerm;

@Profile(Profiles.REPOSITORY_MAP)
public class KeyTermMapRepository extends AbstractMapRepository<KeyTerm> {
}
