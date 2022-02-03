package ru.dpopkov.knownics.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.question.*;

@Component
public class DataLoader implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;

    private Long javaSeCategoryId;
    private Long springCategoryId;

    public DataLoader(CategoryRepository categoryRepository, QuestionRepository questionRepository) {
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
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

    private void loadQuestions() {
        Question spring = new Question();
        Category springCategory = categoryRepository.findById(springCategoryId).orElseThrow();
        spring.setCategory(springCategory);
        spring.addTranslation(new QuestionText(Language.EN, "What is Spring"));
        spring.addTranslation(new QuestionText(Language.RU, "Что такое Spring"));
        spring.setComment("First question");
        questionRepository.save(spring);
        Question java = new Question();
        Category javaSeCategory = categoryRepository.findById(javaSeCategoryId).orElseThrow();
        java.setCategory(javaSeCategory);
        java.addTranslation(new QuestionText(Language.EN, "What is Java"));
        java.addTranslation(new QuestionText(Language.RU, "Что такое Java"));
        java.setComment("Second question");
        questionRepository.save(java);
        System.out.println("Questions loaded...");
    }
}
