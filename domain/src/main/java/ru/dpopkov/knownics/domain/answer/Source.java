package ru.dpopkov.knownics.domain.answer;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.ModifiableEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Source extends ModifiableEntity {

    @NotEmpty
    private String title;
    private String fullTitle;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SourceType type;
    private String url;
    private String description;

    public Source() {
    }

    public Source(String title, SourceType type) {
        this.title = title;
        this.type = type;
    }

    public Source(String title, String fullTitle, SourceType type, String url, String description) {
        this.title = title;
        this.fullTitle = fullTitle;
        this.type = type;
        this.url = url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Source)) return false;

        Source source = (Source) o;

        if (!getTitle().equals(source.getTitle())) return false;
        if (getFullTitle() != null ? !getFullTitle().equals(source.getFullTitle()) : source.getFullTitle() != null)
            return false;
        return getType() == source.getType();
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + (getFullTitle() != null ? getFullTitle().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
