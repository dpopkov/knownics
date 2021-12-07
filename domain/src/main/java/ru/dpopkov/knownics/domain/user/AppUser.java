package ru.dpopkov.knownics.domain.user;

import ru.dpopkov.knownics.domain.ModifiableEntity;

public class AppUser extends ModifiableEntity {

    private String username;

    public AppUser() {
    }

    public AppUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
