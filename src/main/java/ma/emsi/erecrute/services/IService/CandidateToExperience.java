package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;

public interface CandidateToExperience {
    public void addCandidateToExperience(Long candidate_id, Long experience_id) throws CandidateNotFoundException, ExperienceNotFoundException;
}
