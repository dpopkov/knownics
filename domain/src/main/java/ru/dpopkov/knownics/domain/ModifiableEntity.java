package ru.dpopkov.knownics.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class ModifiableEntity extends BaseEntity {

    protected LocalDateTime created = LocalDateTime.now();
    protected LocalDateTime modified;
}
