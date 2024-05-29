package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Education;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.EducationNotFoundException;
import ma.emsi.erecrute.services.IService.CandidateToEducation;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateToEducationImpl implements CandidateToEducation {
    private final ICandidateService candidateService;
    private final IEducationService educationService;

    @Autowired
    public CandidateToEducationImpl(ICandidateService candidateService, IEducationService educationService) {
        this.candidateService = candidateService;
        this.educationService = educationService;
    }

    @Override
    public void addCandidateToEducation(Long candidate_id, Long education_id) throws CandidateNotFoundException, EducationNotFoundException {
        Candidate candidateById = this.candidateService.findCandidateById(candidate_id);
        Education educationById = this.educationService.findEducationById(education_id);
        candidateById.getEducations().add(educationById);
        educationById.setCandidate(candidateById);
    }
}
