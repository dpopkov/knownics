package ru.dpopkov.knownics.repository.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.dpopkov.knownics.domain.BaseEntity;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionText;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles(Profiles.REPOSITORY_JPA)
@EntityScan(basePackageClasses = {BaseEntity.class})
class QuestionJpaRepositoryIT {

    /** Autowiring fixed by adding {@link ModuleTestConfiguration}. */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    QuestionJpaRepository questionJpaRepository;

    @Test
    void testSave() {
        Question question = new Question();
        question.addTranslation(new QuestionText(Language.EN, "What is Java"));
        question.addTranslation(new QuestionText(Language.RU, "Что такое Java"));
        questionJpaRepository.save(question);

        Question found = questionJpaRepository.findById(question.getId()).orElseThrow();
        final Map<Language, QuestionText> translations = found.getTranslations();
        assertEquals(2, translations.size());
        assertTrue(translations.containsKey(Language.EN));
        assertTrue(translations.containsKey(Language.RU));
        assertFalse(translations.containsKey(Language.DE));
    }
}
