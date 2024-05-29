package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.SkillNotFoundException;

public interface CandidateToSkill {
    public void addCandidateToSkill(Long candidate_id, Long skill_id) throws CandidateNotFoundException, SkillNotFoundException;
}
