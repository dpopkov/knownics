package ru.dpopkov.knownics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dpopkov.knownics.services.CategoryService;

@Controller
public class IndexController {

    private final CategoryService categoryService;

    public IndexController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "index";
    }
}
