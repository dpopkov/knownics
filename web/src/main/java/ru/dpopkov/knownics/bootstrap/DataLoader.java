package ru.dpopkov.knownics.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.Language;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.Question;
import ru.dpopkov.knownics.domain.question.QuestionText;
import ru.dpopkov.knownics.services.CategoryService;
import ru.dpopkov.knownics.services.QuestionService;

@Component
public class DataLoader implements CommandLineRunner {
    private final CategoryService categoryService;
    private final QuestionService questionService;

    public DataLoader(CategoryService categoryService, QuestionService questionService) {
        this.categoryService = categoryService;
        this.questionService = questionService;
    }

    @Override
    public void run(String... args) {
        if (categoryService.count() == 0) {
            loadCategories();
        }
        if (questionService.count() == 0) {
            loadQuestions();
        }
    }

    private void loadCategories() {
        Category cat1 = new Category("JavaSE", "Java Standard Edition");
        Category cat2 = new Category("Spring", "Spring Framework");
        categoryService.save(cat1);
        categoryService.save(cat2);
        System.out.println("Categories loaded...");
    }

    private void loadQuestions() {
        Question spring = new Question();
        spring.addTranslation(new QuestionText(Language.EN, "What is Spring"));
        spring.addTranslation(new QuestionText(Language.RU, "Что такое Spring"));
        questionService.save(spring);
        Question java = new Question();
        java.addTranslation(new QuestionText(Language.EN, "What is Java"));
        java.addTranslation(new QuestionText(Language.RU, "Что такое Java"));
        System.out.println("Questions loaded...");
    }
}
