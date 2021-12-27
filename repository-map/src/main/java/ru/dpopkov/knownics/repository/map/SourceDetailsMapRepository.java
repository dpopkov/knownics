package ru.dpopkov.knownics.repository.map;

import ru.dpopkov.knownics.domain.answer.Source;
import ru.dpopkov.knownics.domain.answer.SourceDetails;
import ru.dpopkov.knownics.domain.answer.SourceDetailsRepository;
import ru.dpopkov.knownics.domain.answer.SourceRepository;

public class SourceDetailsMapRepository extends AbstractMapRepository<SourceDetails> implements SourceDetailsRepository {

    private final SourceRepository sourceRepository;

    public SourceDetailsMapRepository(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @Override
    public <S extends SourceDetails> S save(S sourceDetails) {
        final Source source = sourceDetails.getSource();
        if (source.getId() == null) {
            sourceDetails.setSource(sourceRepository.save(source));
        }
        return super.save(sourceDetails);
    }
}
