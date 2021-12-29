package ru.dpopkov.knownics.domain.question;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.ModifiableEntity;
import ru.dpopkov.knownics.domain.user.AppUser;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class QCollection extends ModifiableEntity {

    private String title;
    private String description;
    private AppUser owner;
    private boolean shared;
    private Set<Question> questions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QCollection)) return false;

        QCollection that = (QCollection) o;

        if (!getTitle().equals(that.getTitle())) return false;
        return getOwner() != null ? getOwner().equals(that.getOwner()) : that.getOwner() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        return result;
    }
}
