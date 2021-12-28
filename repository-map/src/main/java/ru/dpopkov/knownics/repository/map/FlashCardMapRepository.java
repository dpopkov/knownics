package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import ru.dpopkov.knownics.domain.deck.FlashCard;
import ru.dpopkov.knownics.domain.deck.FlashCardRepository;

@Profile(Profiles.REPOSITORY_MAP)
public class FlashCardMapRepository extends AbstractMapRepository<FlashCard> implements FlashCardRepository {
}
