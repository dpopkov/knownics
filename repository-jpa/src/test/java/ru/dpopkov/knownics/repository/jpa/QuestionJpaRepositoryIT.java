package ru.dpopkov.knownics.repository.jpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
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

    private static final int BIG_TEXT_SIZE = 1024 * 2;

    /** Autowiring fixed by adding {@link ModuleTestConfiguration}. */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    QuestionJpaRepository questionJpaRepository;
    @Autowired
    TestEntityManager testEntityManager;

    private static String bigText;

    @BeforeAll
    static void setUp() {
        StringBuilder bigTextStringBuilder = new StringBuilder();
        String oneLine = "What is Object-oriented Programming ";
        while (bigTextStringBuilder.length() <= BIG_TEXT_SIZE) {
            bigTextStringBuilder.append(oneLine);
        }
        bigText = bigTextStringBuilder.toString();
    }

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
        QuestionText enQuestionText = translations.get(Language.EN);
        assertEquals(Language.EN, enQuestionText.getLanguage());
        assertEquals("What is Java", enQuestionText.getText());
        assertTrue(translations.containsKey(Language.RU));
        QuestionText ruQuestionText = translations.get(Language.RU);
        assertEquals(Language.RU, ruQuestionText.getLanguage());
        assertEquals("Что такое Java", ruQuestionText.getText());
        assertFalse(translations.containsKey(Language.DE));
    }

    @Test
    void testSaveLargeText() {
        Question question = new Question();
        question.addTranslation(new QuestionText(Language.EN, bigText));
        questionJpaRepository.save(question);
        testEntityManager.flush();  // need this to persist big translation text

        Question found = questionJpaRepository.findById(question.getId()).orElseThrow();
        final Map<Language, QuestionText> translations = found.getTranslations();
        assertEquals(1, translations.size());
        String actualText = translations.get(Language.EN).getText();
        assertEquals(bigText, actualText);
    }
}
