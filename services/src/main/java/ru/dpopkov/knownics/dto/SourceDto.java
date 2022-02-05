package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SourceDto extends ModifiableDto {
    @NotBlank
    private String title;
    private String fullTitle;
    @NotBlank
    private String type;
    private String url;
    private String description;
}
