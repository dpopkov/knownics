package ru.dpopkov.knownics.domain.deck;

import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.domain.question.Question;

public class FlashCard extends ModifiableEntity {

    private int level;
    private String questionText;
    private String answerText;
    private Question originalQuestion;
    private Answer originalAnswer;
    private int totalSuccess;
    private int totalResets;
    private Deck deck;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getOriginalQuestion() {
        return originalQuestion;
    }

    public void setOriginalQuestion(Question originalQuestion) {
        this.originalQuestion = originalQuestion;
    }

    public Answer getOriginalAnswer() {
        return originalAnswer;
    }

    public void setOriginalAnswer(Answer originalAnswer) {
        this.originalAnswer = originalAnswer;
    }

    public int getTotalSuccess() {
        return totalSuccess;
    }

    public void setTotalSuccess(int totalSuccess) {
        this.totalSuccess = totalSuccess;
    }

    public int getTotalResets() {
        return totalResets;
    }

    public void setTotalResets(int totalResets) {
        this.totalResets = totalResets;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
