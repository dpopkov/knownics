package ru.dpopkov.knownics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dpopkov.knownics.services.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "questions/list";
    }
}
