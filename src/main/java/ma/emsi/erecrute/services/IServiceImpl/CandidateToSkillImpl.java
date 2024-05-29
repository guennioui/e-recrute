package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Skill;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.SkillNotFoundException;
import ma.emsi.erecrute.services.IService.CandidateToSkill;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateToSkillImpl implements CandidateToSkill {
    private final ICandidateService candidateService;
    private final ISkillService skillService;

    @Autowired
    public CandidateToSkillImpl(ICandidateService candidateService, ISkillService skillService) {
        this.candidateService = candidateService;
        this.skillService = skillService;
    }

    @Override
    public void addCandidateToSkill(Long candidate_id, Long skill_id) throws CandidateNotFoundException, SkillNotFoundException {
        Candidate candidateById = this.candidateService.findCandidateById(candidate_id);
        Skill skillById = this.skillService.findSkillById(skill_id);
        candidateById.getSkills().add(skillById);
        skillById.setCandidate(candidateById);
    }
}
