package ru.dpopkov.knownics.domain.answer;

import ru.dpopkov.knownics.domain.ModifiableEntity;

public class SourceDetails extends ModifiableEntity {

    private Source source;
    private String details;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
