package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;
import ma.emsi.erecrute.exceptions.LanguageNotFoundException;

public interface LanguageToLanguageCandidate {
    public void addLanguageToLanguageCandidate(Long language_candidate_id, Long language_id) throws LanguageNotFoundException, LanguageCandidateNotFoundException;
}
