package ru.dpopkov.knownics.repository.map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dpopkov.knownics.domain.deck.Deck;
import ru.dpopkov.knownics.domain.deck.FlashCard;
import ru.dpopkov.knownics.domain.deck.FlashCardRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;

@ExtendWith(MockitoExtension.class)
class DeckMapRepositoryTest {
    @Mock
    FlashCardRepository flashCardRepository;
    @InjectMocks
    DeckMapRepository deckMapRepository;

    @Test
    void testSave() {
        // Given
        Deck deck = new Deck();
        deck.addFlashCard(new FlashCard());
        deck.addFlashCard(new FlashCard());
        // When
        deckMapRepository.save(deck);
        // Then
        assertThat(deck.getId()).isNotNull();
        then(flashCardRepository).should(times(2)).save(any(FlashCard.class));
    }
}
