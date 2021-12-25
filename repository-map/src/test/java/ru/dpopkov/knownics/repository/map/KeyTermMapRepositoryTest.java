package ru.dpopkov.knownics.repository.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.dpopkov.knownics.domain.KeyTerm;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class KeyTermMapRepositoryTest {
    private final KeyTermMapRepository repository = new KeyTermMapRepository();

    @DisplayName("Saved Entity receives ID")
    @Test
    void testSave() {
        // Given
        KeyTerm keyTerm = new KeyTerm("name", "desc");
        // When
        final KeyTerm saved = repository.save(keyTerm);
        // Then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getDescription()).isEqualTo("desc");
    }

    @DisplayName("Saved 2nd Entity receives incremented ID")
    @Test
    void testSaveConsecutive() {
        // Given
        KeyTerm keyTerm = new KeyTerm("name", "desc");
        KeyTerm keyTerm2 = new KeyTerm("name2", "desc2");
        // When
        final KeyTerm saved = repository.save(keyTerm);
        final KeyTerm savedNext = repository.save(keyTerm2);
        // Then
        assertThat(saved.getId()).isNotNull();
        assertThat(savedNext.getId()).isNotNull();
        long expectedNext = saved.getId() + 1;
        assertEquals(expectedNext, (long) savedNext.getId());
    }

    @DisplayName("Save All saves all entities and assigns IDs")
    @Test
    void testSaveAll() {
        // Given
        final KeyTerm kt1 = new KeyTerm("name", "desc");
        final KeyTerm kt2 = new KeyTerm("name2", "desc");
        final KeyTerm kt3 = new KeyTerm("name3", "desc");
        List<KeyTerm> list = List.of(kt1, kt2, kt3);
        // When
        final Iterable<KeyTerm> saved = repository.saveAll(list);
        // Then
        assertThat(saved).hasSize(3);
        assertThat(saved).contains(kt1, kt2, kt3);
        assertThat(saved).extracting(KeyTerm::getId).doesNotContainNull();
    }

    @DisplayName("Find All returns all entities")
    @Test
    void testFindAll() {
        // Given
        final KeyTerm kt1 = new KeyTerm("name", "desc");
        final KeyTerm kt2 = new KeyTerm("name2", "desc");
        repository.save(kt1);
        repository.save(kt2);
        // When
        final Iterable<KeyTerm> all = repository.findAll();
        // Then
        assertThat(all).hasSize(2);
        assertThat(all).contains(kt1, kt2);
        assertThat(all).extracting(KeyTerm::getId).doesNotContainNull();
    }

    @DisplayName("Can find by ID")
    @Test
    void testFindById() {
        // Given
        final KeyTerm kt1 = new KeyTerm("name", "desc");
        final KeyTerm kt2 = new KeyTerm("name2", "desc");
        repository.save(kt1);
        repository.save(kt2);
        // When
        KeyTerm found1 = repository.findById(kt1.getId()).orElseThrow();
        // Then
        assertThat(found1.getId()).isEqualTo(kt1.getId());
        assertThat(found1.getName()).isEqualTo(kt1.getName());
    }

    @DisplayName("Can delete by ID")
    @Test
    void testDeleteById() {
        // Given
        final KeyTerm kt1 = new KeyTerm("name", "desc");
        final KeyTerm kt2 = new KeyTerm("name2", "desc");
        repository.save(kt1);
        repository.save(kt2);
        // When
        repository.deleteById(kt1.getId());
        // Then
        assertThat(repository.count()).isEqualTo(1);
        assertTrue(repository.findById(kt1.getId()).isEmpty());
        assertTrue(repository.findById(kt2.getId()).isPresent());
    }

    @DisplayName("Can delete object")
    @Test
    void testDelete() {
        // Given
        final KeyTerm kt1 = new KeyTerm("name", "desc");
        final KeyTerm kt2 = new KeyTerm("name2", "desc");
        repository.save(kt1);
        repository.save(kt2);
        // When
        repository.delete(kt1);
        // Then
        assertThat(repository.count()).isEqualTo(1);
        assertTrue(repository.findById(kt1.getId()).isEmpty());
        assertTrue(repository.findById(kt2.getId()).isPresent());
    }

    @DisplayName("When delete object with null id then throw exception")
    @Test
    void testDeleteNullId() {
        // Given
        final KeyTerm kt1 = new KeyTerm("name", "desc");
        // When - Then
        assertThrows(IllegalArgumentException.class, () -> repository.delete(kt1));
    }

    @DisplayName("Can delete all")
    @Test
    void testDeleteAll() {
        // Given
        final KeyTerm kt1 = new KeyTerm("name", "desc");
        final KeyTerm kt2 = new KeyTerm("name2", "desc");
        repository.save(kt1);
        repository.save(kt2);
        // When
        repository.deleteAll();
        // Then
        assertThat(repository.count()).isEqualTo(0);
        assertThat(repository.findById(kt1.getId())).isEmpty();
        assertThat(repository.findById(kt2.getId())).isEmpty();
    }
}
