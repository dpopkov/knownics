package ru.dpopkov.knownics.repository.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ru.dpopkov.knownics.domain.BaseEntity;
import ru.dpopkov.knownics.domain.question.Category;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles(Profiles.REPOSITORY_JPA)
@EntityScan(basePackageClasses = {BaseEntity.class})
@Sql(scripts = {"/categories.sql"})
class CategoryJpaRepositoryIT {

    /** Autowiring fixed by adding {@link ModuleTestConfiguration}. */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    CategoryJpaRepository repository;

    @DisplayName("Can find by description")
    @Test
    void testFindByDescription() {
        assertEquals(4, repository.count());
        final Category spring = repository.findByDescription("Spring Framework").orElseThrow();
        assertEquals("Spring", spring.getName());
        assertEquals("Spring Framework", spring.getDescription());
    }

    @DisplayName("Can save and creation timestamp of persisted entity is not null")
    @Test
    void testSave() {
        Category angular = new Category("Angular", "Angular Framework");
        repository.save(angular);
        final long numCategories = repository.count();
        assertEquals(5, numCategories);
        Category foundAngular = repository.findByDescription("Angular Framework").orElseThrow();
        final LocalDateTime createdOn = foundAngular.getCreatedOn();
        assertNotNull(createdOn);
        System.out.println("createdOn = " + createdOn);
    }

    @DisplayName("Modification timestamp is changed after entity is modified")
    @Test
    void testModificationTimestamp() {
        final Category spring = repository.findByDescription("Spring Framework").orElseThrow();
        final LocalDateTime modifiedOn1 = spring.getModifiedOn();
        System.out.println("modifiedOn1 = " + modifiedOn1);

        spring.setDescription("Spring 5 Framework");
        repository.save(spring);
        assertEquals(4, repository.count());

        Category foundSpring = repository.findById(spring.getId()).orElseThrow();
        final LocalDateTime modifiedOn2 = foundSpring.getModifiedOn();
        System.out.println("modifiedOn2 = " + modifiedOn2);
        assertNotEquals(modifiedOn1, modifiedOn2);
        foundSpring.setDescription("Spring 6 Framework");
        repository.save(foundSpring);
        assertEquals(4, repository.count());

        Category foundSpring2 = repository.findById(spring.getId()).orElseThrow();
        final LocalDateTime modifiedOn3 = foundSpring2.getModifiedOn();
        System.out.println("modifiedOn3 = " + modifiedOn3);
        assertNotEquals(modifiedOn2, modifiedOn3);
    }
}
