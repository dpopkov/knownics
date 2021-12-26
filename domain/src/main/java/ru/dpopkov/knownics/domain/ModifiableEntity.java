package ru.dpopkov.knownics.domain;

import java.time.LocalDateTime;

public abstract class ModifiableEntity extends BaseEntity {

    protected LocalDateTime created = LocalDateTime.now();
    protected LocalDateTime modified;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
