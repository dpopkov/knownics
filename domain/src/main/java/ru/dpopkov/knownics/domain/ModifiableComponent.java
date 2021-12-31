package ru.dpopkov.knownics.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
@MappedSuperclass
public abstract class ModifiableComponent {

    @Column(name = "CREATED_ON")
    @org.hibernate.annotations.CreationTimestamp
    protected LocalDateTime createdOn = LocalDateTime.now();

    @Column(name = "MODIFIED_ON")
    @org.hibernate.annotations.UpdateTimestamp
    protected LocalDateTime modifiedOn;
}
