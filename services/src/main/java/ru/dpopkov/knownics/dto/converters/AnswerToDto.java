package ru.dpopkov.knownics.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.dto.AnswerDto;
import ru.dpopkov.knownics.dto.TranslationDto;

@Component
public class AnswerToDto implements Converter<Answer, AnswerDto> {
    private final TranslationToDto translationToDto;
    private final SourceDetailsToDto sourceDetailsToDto;

    public AnswerToDto(TranslationToDto translationToDto, SourceDetailsToDto sourceDetailsToDto) {
        this.translationToDto = translationToDto;
        this.sourceDetailsToDto = sourceDetailsToDto;
    }

    @Override
    public AnswerDto convert(Answer source) {
        AnswerDto dto = new AnswerDto();
        dto.setId(source.getId());
        dto.setCreatedOn(source.getCreatedOn());
        dto.setModifiedOn(source.getModifiedOn());
        dto.setType(source.getType().toString());
        source.getTranslations().forEach((key, value) -> {
            TranslationDto translationDto = translationToDto.convert(value);
            assert translationDto != null;
            dto.getTranslations().put(translationDto.getLanguage(), translationDto);
        });
        dto.setSourceDetails(sourceDetailsToDto.convert(source.getSourceDetails()));
        dto.setComment(source.getComment());
        return dto;
    }
}
