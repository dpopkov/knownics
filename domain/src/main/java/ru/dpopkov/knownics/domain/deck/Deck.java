package ru.dpopkov.knownics.domain.deck;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.user.AppUser;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Deck extends ModifiableEntity {

    private String name;
    private String description;
    private AppUser owner;
    private Set<FlashCard> flashCards = new HashSet<>();
    private Set<StudySession> studySessions = new HashSet<>(); // collection of components

    public void addFlashCard(FlashCard flashCard) {
        flashCards.add(flashCard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deck)) return false;

        Deck deck = (Deck) o;

        if (!getName().equals(deck.getName())) return false;
        if (getDescription() != null ? !getDescription().equals(deck.getDescription()) : deck.getDescription() != null)
            return false;
        return getOwner() != null ? getOwner().equals(deck.getOwner()) : deck.getOwner() == null;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        return result;
    }
}
