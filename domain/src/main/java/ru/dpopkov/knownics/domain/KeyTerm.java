package ru.dpopkov.knownics.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.user.AppUser;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
public class KeyTerm extends ModifiableEntity {

    @NotEmpty
    private String name;
    private String description;
    @ManyToOne
    private AppUser createdBy;
    @ManyToOne
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
