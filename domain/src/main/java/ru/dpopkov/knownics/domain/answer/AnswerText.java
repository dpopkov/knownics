package ru.dpopkov.knownics.domain.answer;

import ru.dpopkov.knownics.domain.AbstractTranslation;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.TextType;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerText extends AbstractTranslation {

    public AnswerText() {
    }

    public AnswerText(Language language, String text) {
        super(language, text);
    }

    public AnswerText(Language language, TextType type, String text) {
        super(language, type, text);
    }

    @Override
    public String toString() {
        return "AnswerText" + super.toString();
    }
}
