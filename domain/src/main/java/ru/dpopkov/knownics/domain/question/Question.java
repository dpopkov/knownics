package ru.dpopkov.knownics.domain.question;

import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.domain.user.AppUser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question extends ModifiableEntity {

    private Category category;
    private Map<Language, QuestionText> translations = new HashMap<>();
    private Set<Answer> answers = new HashSet<>();
    private Answer preferredAnswer;
    private Set<KeyTerm> keyTerms = new HashSet<>();
    private String comment;
    private AppUser createdBy;
    private AppUser modifiedBy;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Map<Language, QuestionText> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<Language, QuestionText> translations) {
        this.translations = translations;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Answer getPreferredAnswer() {
        return preferredAnswer;
    }

    public void setPreferredAnswer(Answer preferredAnswer) {
        this.preferredAnswer = preferredAnswer;
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
