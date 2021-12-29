package ru.dpopkov.knownics.domain.question;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.domain.user.AppUser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Question extends ModifiableEntity {

    private Category category;
    private Map<Language, QuestionText> translations = new HashMap<>();
    private Set<Answer> answers = new HashSet<>();
    private Answer preferredAnswer;
    private Set<KeyTerm> keyTerms = new HashSet<>();
    private String comment;
    private AppUser createdBy;
    private AppUser modifiedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (getCategory() != null ? !getCategory().equals(question.getCategory()) : question.getCategory() != null)
            return false;
        return getTranslations() != null ? getTranslations().equals(question.getTranslations()) : question.getTranslations() == null;
    }

    @Override
    public int hashCode() {
        int result = getCategory() != null ? getCategory().hashCode() : 0;
        result = 31 * result + (getTranslations() != null ? getTranslations().hashCode() : 0);
        return result;
    }
}
