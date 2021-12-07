package ru.dpopkov.knownics.domain.question;

import ru.dpopkov.knownics.domain.AbstractTranslation;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.TextType;

/**
 * Question Translation
 */
public class QuestionText extends AbstractTranslation {

    public QuestionText() {
    }

    public QuestionText(Language language, TextType type, String text) {
        super(language, type, text);
    }

    @Override
    public String toString() {
        return "QuestionText" + super.toString();
    }
}
