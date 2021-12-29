package ru.dpopkov.knownics.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.user.AppUser;

@Getter
@Setter
public class KeyTerm extends ModifiableEntity {

    private String name;
    private String description;
    private AppUser createdBy;
    private AppUser modifiedBy;

    public KeyTerm() {
    }

    public KeyTerm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Builder
    public KeyTerm(String name, String description, AppUser createdBy, AppUser modifiedBy) {
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "KeyTerm{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyTerm)) return false;

        KeyTerm keyTerm = (KeyTerm) o;

        return getName().equals(keyTerm.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
