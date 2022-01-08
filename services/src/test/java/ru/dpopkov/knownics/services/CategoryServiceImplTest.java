package ru.dpopkov.knownics.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Mock
    CategoryRepository repository;
    @InjectMocks
    CategoryServiceImpl service;
    @Mock
    Category category;
    @Captor
    ArgumentCaptor<Category> categoryCaptor;

    @Test
    void testSave() {
        given(category.getName()).willReturn("sql");
        service.save(category);
        then(repository).should().save(categoryCaptor.capture());
        assertThat(categoryCaptor.getValue().getName()).isEqualTo("sql");
    }

    @Test
    void testSaveAll() {
        service.saveAll(new ArrayList<>());
        then(repository).should().saveAll(any());
    }

    @Test
    void testFindAll() {
        List<Category> categories = List.of(new Category(), new Category());
        given(repository.findAll()).willReturn(categories);

        final Iterable<Category> all = service.findAll();

        then(repository).should().findAll();
        assertTrue(all.iterator().hasNext());
        all.iterator().next();
        assertTrue(all.iterator().hasNext());
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

    @Test
    void testDelete() {
        final Category category = new Category();
        service.delete(category);
        then(repository).should().delete(category);
    }

    @Test
    void testDeleteAll() {
        service.deleteAll();
        then(repository).should().deleteAll();
    }

    @Test
    void testCount() {
        service.count();
        then(repository).should().count();
    }
}
