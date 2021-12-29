package ru.dpopkov.knownics.domain.user;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.ModifiableEntity;

@Getter
@Setter
public class AppUser extends ModifiableEntity {

    private String username;

    public AppUser() {
    }

    public AppUser(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;

        AppUser appUser = (AppUser) o;

        return getUsername().equals(appUser.getUsername());
    }

    @Override
    public int hashCode() {
        return getUsername().hashCode();
    }
}
