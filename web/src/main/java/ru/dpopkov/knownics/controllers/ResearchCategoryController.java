package ru.dpopkov.knownics.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

@Slf4j
@Controller
@RequestMapping("/research")
public class ResearchCategoryController {

    private final CategoryRepository repository;

    public ResearchCategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reset/{categoryId}")
    public String nullModificationTime(@PathVariable Long categoryId) {
        log.info("Inside nullModificationTime for categoryId={}", categoryId);
        final Category category = repository.findById(categoryId).orElseThrow();
        category.setCreatedOn(null);
        category.setModifiedOn(null);
        log.info("About to save: {}", category);
        final Category saved = repository.save(category);
        log.info("Saved Category: {}", saved);
        return "redirect:/";
    }
}
