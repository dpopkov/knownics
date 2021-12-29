package ru.dpopkov.knownics.domain.answer;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.ModifiableEntity;

@Getter
@Setter
public class SourceDetails extends ModifiableEntity {

    private Source source;
    private String details;

    public SourceDetails(Source source, String details) {
        this.source = source;
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SourceDetails)) return false;

        SourceDetails details1 = (SourceDetails) o;

        if (!getSource().equals(details1.getSource())) return false;
        return getDetails().equals(details1.getDetails());
    }

    @Override
    public int hashCode() {
        int result = getSource().hashCode();
        result = 31 * result + getDetails().hashCode();
        return result;
    }
}
