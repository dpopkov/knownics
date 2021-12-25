package ru.dpopkov.knownics.repository.map;

import ru.dpopkov.knownics.domain.deck.Deck;
import ru.dpopkov.knownics.domain.deck.DeckRepository;
import ru.dpopkov.knownics.domain.deck.FlashCard;
import ru.dpopkov.knownics.domain.deck.FlashCardRepository;

public class DeckMapRepository extends AbstractMapRepository<Deck> implements DeckRepository {

    private final FlashCardRepository flashCardRepository;

    public DeckMapRepository(FlashCardRepository flashCardRepository) {
        this.flashCardRepository = flashCardRepository;
    }

    @Override
    public Deck save(Deck object) {
        for (FlashCard card : object.getFlashCards()) {
            if (card.getId() == null) {
                flashCardRepository.save(card);
            }
        }
        return super.save(object);
    }
}
