package ru.dpopkov.knownics.repository.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.dpopkov.knownics.domain.question.Category;
import ru.dpopkov.knownics.domain.question.CategoryRepository;

import java.util.Optional;

@Repository
@Profile(Profiles.REPOSITORY_MAP)
public class CategoryMapRepository extends AbstractMapRepository<Category> implements CategoryRepository {
    @Override
    public Optional<Category> findByDescription(String description) {
        for (Category category : super.findAll()) {
            if (description.equals(category.getDescription())) {
                return  Optional.of(category);
            }
        }
        return Optional.empty();
    }
}
