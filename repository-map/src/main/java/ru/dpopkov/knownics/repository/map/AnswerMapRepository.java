package ru.dpopkov.knownics.repository.map;

import ru.dpopkov.knownics.domain.KeyTerm;
import ru.dpopkov.knownics.domain.KeyTermRepository;
import ru.dpopkov.knownics.domain.answer.Answer;
import ru.dpopkov.knownics.domain.answer.AnswerRepository;
import ru.dpopkov.knownics.domain.answer.SourceDetails;
import ru.dpopkov.knownics.domain.answer.SourceDetailsRepository;

import java.util.Set;

public class AnswerMapRepository extends AbstractMapRepository<Answer> implements AnswerRepository {

    private final SourceDetailsRepository sourceDetailsRepository;
    private final KeyTermRepository keyTermRepository;

    public AnswerMapRepository(SourceDetailsRepository sourceDetailsRepository, KeyTermRepository keyTermRepository) {
        this.sourceDetailsRepository = sourceDetailsRepository;
        this.keyTermRepository = keyTermRepository;
    }

    @Override
    public Answer save(Answer answer) {
        if (answer.getCreatedBy() == null || answer.getCreatedBy().getId() == null) {
            throw new IllegalStateException("Field createdBy should contain existing User");
        }
        if (answer.getModifiedBy() != null && answer.getModifiedBy().getId() == null) {
            throw new IllegalStateException("Field modifiedBy should contain null or existing user");
        }
        final SourceDetails sourceDetails = answer.getSourceDetails();
        if (sourceDetails != null && sourceDetails.getId() == null) {
            answer.setSourceDetails(sourceDetailsRepository.save(sourceDetails));
        }
        final Set<KeyTerm> keyTerms = answer.getKeyTerms();
        for (KeyTerm kt : keyTerms) {
            if (kt.getId() == null) {
                keyTermRepository.save(kt);
            }
        }
        return super.save(answer);
    }
}
