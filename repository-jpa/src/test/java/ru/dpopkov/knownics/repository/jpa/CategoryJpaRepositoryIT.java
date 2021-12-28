package ru.dpopkov.knownics.repository.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ru.dpopkov.knownics.domain.question.Category;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles(Profiles.REPOSITORY_JPA)
@EntityScan(basePackageClasses = {Category.class})
@Sql(scripts = {"/categories.sql"})
class CategoryJpaRepositoryIT {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") // fixed by adding DataModuleTestConfiguration
    @Autowired
    CategoryJpaRepository repository;

    @Test
    void testFindByDescription() {
        assertEquals(4, repository.count());
        final Category spring = repository.findByDescription("Spring Framework").orElseThrow();
        assertEquals("Spring", spring.getName());
        assertEquals("Spring Framework", spring.getDescription());
    }
}
