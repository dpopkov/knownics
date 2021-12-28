package ru.dpopkov.knownics.repository.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.question.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapRepositoryTest {

    CategoryMapRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CategoryMapRepository();
        repository.save(new Category("JavaSE", "Java Standard Edition"));
    }

    @Test
    void findByDescription() {
        final Category java = repository.findByDescription("Java Standard Edition").orElseThrow();
        assertEquals("JavaSE", java.getName());
        assertEquals("Java Standard Edition", java.getDescription());
    }
}
