package ru.dpopkov.knownics.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Mock
    CategoryRepository repository;
    @InjectMocks
    CategoryServiceImpl service;
    @Mock
    Category category;

    @Test
    void testSave() {
        service.save(category);
        then(repository).should().save(any(Category.class));
    }

    @Test
    void testFindById() {
        service.findById(12L);
        then(repository).should().findById(12L);
    }

    @Test
    void testDeleteId() {
        service.deleteById(12L);
        then(repository).should().deleteById(12L);
    }
}
