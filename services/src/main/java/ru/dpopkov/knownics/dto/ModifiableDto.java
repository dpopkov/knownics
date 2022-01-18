package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ModifiableDto extends BaseDto {
    protected LocalDateTime createdOn;
    protected LocalDateTime modifiedOn;
}
