package ru.dpopkov.knownics.domain.deck;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.domain.question.Question;

@Getter
@Setter
public class FlashCard extends ModifiableEntity {

    private int level;
    private String questionText;
    private String answerText;
    private Question originalQuestion;
    private Answer originalAnswer;
    private int totalSuccess;
    private int totalResets;
    private Deck deck;

    public FlashCard() {
    }

    public FlashCard(String questionText, String answerText) {
        this.questionText = questionText;
        this.answerText = answerText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashCard)) return false;

        FlashCard flashCard = (FlashCard) o;

        if (getQuestionText() != null ? !getQuestionText().equals(flashCard.getQuestionText()) : flashCard.getQuestionText() != null)
            return false;
        if (getAnswerText() != null ? !getAnswerText().equals(flashCard.getAnswerText()) : flashCard.getAnswerText() != null)
            return false;
        return getDeck() != null ? getDeck().equals(flashCard.getDeck()) : flashCard.getDeck() == null;
    }

    @Override
    public int hashCode() {
        int result = getQuestionText() != null ? getQuestionText().hashCode() : 0;
        result = 31 * result + (getAnswerText() != null ? getAnswerText().hashCode() : 0);
        result = 31 * result + (getDeck() != null ? getDeck().hashCode() : 0);
        return result;
    }
}
