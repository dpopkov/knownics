package ru.dpopkov.knownics.domain.question;

import ru.dpopkov.knownics.domain.ModifiableEntity;

public class Category extends ModifiableEntity {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
