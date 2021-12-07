package ru.dpopkov.knownics.domain;

public interface Translation {

    Language getLanguage();

    TextType getType();

    String getText();
}
