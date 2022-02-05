package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SourceDetailsDto extends ModifiableDto {
    @NotBlank
    private String sourceTitle;
    @NotBlank
    private String sourceType;
    private String sourceUrl;
    @NotBlank
    private String details;
}
