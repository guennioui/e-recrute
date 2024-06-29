package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;

public interface CandidateToCandidacy {
    public void addCandidateToCandidacy(String username, Long Candidacy_id) throws CandidateNotFoundException, CandidacyNotFoundException;
}
