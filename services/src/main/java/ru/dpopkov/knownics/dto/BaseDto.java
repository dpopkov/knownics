package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;
import ru.dpopkov.knownics.domain.HavingId;

@Getter
@Setter
public abstract class BaseDto implements HavingId {
    private Long id;
}
