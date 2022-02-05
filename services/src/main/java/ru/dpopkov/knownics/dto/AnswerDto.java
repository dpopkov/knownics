package ru.dpopkov.knownics.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class AnswerDto extends ModifiableDto {

    @NotBlank
    private String type;
    @NotEmpty
    private Map<String, TranslationDto> translations = new HashMap<>();
    @NotNull
    private SourceDetailsDto sourceDetails;
    private String comment;
}
