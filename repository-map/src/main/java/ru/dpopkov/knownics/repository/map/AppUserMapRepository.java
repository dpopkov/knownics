package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import ru.dpopkov.knownics.domain.user.AppUser;
import ru.dpopkov.knownics.domain.user.AppUserRepository;

@Profile(Profiles.REPOSITORY_MAP)
public class AppUserMapRepository extends AbstractMapRepository<AppUser> implements AppUserRepository {
}
