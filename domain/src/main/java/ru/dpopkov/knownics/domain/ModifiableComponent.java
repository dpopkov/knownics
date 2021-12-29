package ru.dpopkov.knownics.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ModifiableComponent {

    protected LocalDateTime created = LocalDateTime.now();
    protected LocalDateTime modified;
}
