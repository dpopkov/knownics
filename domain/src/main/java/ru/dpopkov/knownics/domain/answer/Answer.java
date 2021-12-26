package ru.dpopkov.knownics.domain.answer;

import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.user.AppUser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public Answer(AnswerType type, SourceDetails sourceDetails, String comment, AppUser createdBy, AppUser modifiedBy) {
        this.type = type;
        this.sourceDetails = sourceDetails;
        this.comment = comment;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public AnswerType getType() {
        return type;
    }

    public void setType(AnswerType type) {
        this.type = type;
    }

    public Map<Language, AnswerText> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<Language, AnswerText> translations) {
        this.translations = translations;
    }

    public SourceDetails getSourceDetails() {
        return sourceDetails;
    }

    public void setSourceDetails(SourceDetails sourceDetails) {
        this.sourceDetails = sourceDetails;
    }

    public Set<KeyTerm> getKeyTerms() {
        return keyTerms;
    }

    public void setKeyTerms(Set<KeyTerm> keyTerms) {
        this.keyTerms = keyTerms;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public AppUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
        this.createdBy = createdBy;
    }

    public AppUser getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(AppUser modifiedBy) {
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
