package ru.dpopkov.knownics.domain;

import java.util.Date;

public class ModifiableEntity extends BaseEntity {

    protected Date created;
    protected Date modified;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
