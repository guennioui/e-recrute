package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;
import ma.emsi.erecrute.services.IService.CandidateToExperience;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateToExperienceImpl implements CandidateToExperience {
    private final ICandidateService candidateService;
    private final IExperienceService experienceService;

    @Autowired
    public CandidateToExperienceImpl(ICandidateService candidateService, IExperienceService experienceService) {
        this.candidateService = candidateService;
        this.experienceService = experienceService;
    }

    @Override
    public void addCandidateToExperience(Long candidate_id, Long experience_id) throws CandidateNotFoundException, ExperienceNotFoundException {
        Candidate candidateById = this.candidateService.findCandidateById(candidate_id);
        Experience experienceById = this.experienceService.findExperienceById(experience_id);
        candidateById.getExperiences().add(experienceById);
        experienceById.setCandidate(candidateById);
    }
}
