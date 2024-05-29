package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.EducationNotFoundException;

public interface CandidateToEducation {
    public void addCandidateToEducation(Long candidate_id, Long education_id) throws CandidateNotFoundException, EducationNotFoundException;
}
