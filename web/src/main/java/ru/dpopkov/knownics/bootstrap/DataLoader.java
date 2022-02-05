package ru.dpopkov.knownics.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.answer.*;
import ru.dpopkov.knownics.domain.question.*;

@Component
public class DataLoader implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    private final SourceRepository sourceRepository;

    private Long javaSeCategoryId;
    private Long springCategoryId;

    public DataLoader(CategoryRepository categoryRepository, QuestionRepository questionRepository, SourceRepository sourceRepository) {
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
        this.sourceRepository = sourceRepository;
    }


    @Override
    public void run(String... args) {
//        if (categoryService.count() == 0) {
            loadCategories();
//        }
        if (questionRepository.count() == 0) {
            loadQuestions();
        }
    }

    private void loadCategories() {
        Category javaSeCategory = new Category("JavaSE", "Java Standard Edition");
        Category springCategory = new Category("Spring", "Spring Framework");
        Category saved1 = categoryRepository.save(javaSeCategory);
        javaSeCategoryId = saved1.getId();
        Category saved2 = categoryRepository.save(springCategory);
        springCategoryId = saved2.getId();
        System.out.println("Categories loaded...");
        System.out.println("id=" + javaSeCategoryId);
        System.out.println("id=" + springCategoryId);
    }

    public void loadQuestions() {
        Source source = new Source("Good Source", SourceType.BOOK);
        sourceRepository.save(source);
        Question spring = new Question();
        Category springCategory = categoryRepository.findById(springCategoryId).orElseThrow();
        spring.setCategory(springCategory);
        spring.addTranslation(new QuestionText(Language.EN, "What is Spring"));
        spring.addTranslation(new QuestionText(Language.RU, "Что такое Spring"));
        spring.setComment("First question");
        Answer springAnswer = Answer.builder().type(AnswerType.ORIGINAL).build();
        springAnswer.setSourceDetails(new SourceDetails(source, "Page 123"));
        springAnswer.addTranslation(new AnswerText(Language.EN,
                "Spring is the most popular application development framework for enterprise Java"));
        spring.addAnswer(springAnswer);
        Answer springAnswer2 = Answer.builder().type(AnswerType.ORIGINAL).build();
        springAnswer2.setSourceDetails(new SourceDetails(source, "Page 124"));
        springAnswer2.addTranslation(new AnswerText(Language.RU,
                "Spring это наиболее популярный фреймворк для Enterprise Java разработки"));
        spring.addAnswer(springAnswer2);
        questionRepository.save(spring);
        Question java = new Question();
        Category javaSeCategory = categoryRepository.findById(javaSeCategoryId).orElseThrow();
        java.setCategory(javaSeCategory);
        java.addTranslation(new QuestionText(Language.EN, "What is Java"));
        java.addTranslation(new QuestionText(Language.RU, "Что такое Java"));
        java.setComment("Second question");
        Answer javaAnswer = Answer.builder().type(AnswerType.ORIGINAL).build();
        javaAnswer.setSourceDetails(new SourceDetails(source, "Page 125"));
        javaAnswer.addTranslation(new AnswerText(Language.EN,
                "Java is a cross-platform object-oriented programming language"));
        java.addAnswer(javaAnswer);
        questionRepository.save(java);
        System.out.println("Questions loaded...");
    }
}
