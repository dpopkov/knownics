package ru.dpopkov.knownics.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.services.CategoryService;

@Component
public class DataLoader implements CommandLineRunner {
    private final CategoryService categoryService;

    public DataLoader(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) {
        if (categoryService.count() == 0) {
            loadCategories();
        }
    }

    private void loadCategories() {
        Category cat1 = new Category("Java Core");
        Category cat2 = new Category("Spring Framework");
        categoryService.save(cat1);
        categoryService.save(cat2);
        System.out.println("Categories loaded...");
    }
}
