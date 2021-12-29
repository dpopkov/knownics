package ru.dpopkov.knownics.domain.answer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.user.AppUser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Answer extends ModifiableEntity {

    private AnswerType type;
    private Map<Language, AnswerText> translations = new HashMap<>();
    private SourceDetails sourceDetails;
    private Set<KeyTerm> keyTerms = new HashSet<>();
    private String comment;
    private AppUser createdBy;
    private AppUser modifiedBy;

    public Answer() {
    }

    @Builder
    public Answer(AnswerType type, SourceDetails sourceDetails, String comment, AppUser createdBy, AppUser modifiedBy) {
        this.type = type;
        this.sourceDetails = sourceDetails;
        this.comment = comment;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public void addTranslation(AnswerText translation) {
        translations.put(translation.getLanguage(), translation);
    }

    public void addKeyTerm(KeyTerm keyTerm) {
        keyTerms.add(keyTerm);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        if (getType() != answer.getType()) return false;
        return getTranslations() != null ? getTranslations().equals(answer.getTranslations()) : answer.getTranslations() == null;
    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getTranslations() != null ? getTranslations().hashCode() : 0);
        return result;
    }
}
