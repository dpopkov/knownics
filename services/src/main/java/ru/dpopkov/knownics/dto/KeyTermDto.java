package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class KeyTermDto extends ModifiableDto {
    @NotEmpty
    private String name;
    private String description;
}
