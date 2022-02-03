package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TranslationDto extends ModifiableDto {
    @NotEmpty
    private String language;
    @NotEmpty
    private String type;
    @NotEmpty
    private String text;
}
