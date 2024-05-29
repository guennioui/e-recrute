package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;

public interface CandidateToLanguageCandidate {
    public void addCandidateToLanguageCandidate(Long language_candidate_id, Long candidate_id) throws CandidateNotFoundException, LanguageCandidateNotFoundException;
}
