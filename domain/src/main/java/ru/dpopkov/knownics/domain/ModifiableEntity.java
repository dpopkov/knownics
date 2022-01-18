package ru.dpopkov.knownics.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class ModifiableEntity extends BaseEntity {

    @Column(name = "CREATED_ON", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    protected LocalDateTime createdOn;

    @Column(name = "MODIFIED_ON")
    @org.hibernate.annotations.UpdateTimestamp
    protected LocalDateTime modifiedOn;

    @Override
    public String toString() {
        return "{" +
                "createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                "} " + super.toString();
    }
}
