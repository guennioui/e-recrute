package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.services.IService.CandidateToCandidacy;
import ma.emsi.erecrute.services.IService.ICandidacyService;
import ma.emsi.erecrute.services.IService.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateToCandidacyImpl implements CandidateToCandidacy {
    private final ICandidateService candidateService;
    private final ICandidacyService candidacyService;

    @Autowired
    public CandidateToCandidacyImpl(ICandidateService candidateService, ICandidacyService candidacyService) {
        this.candidateService = candidateService;
        this.candidacyService = candidacyService;
    }

    @Override
    public void addCandidateToCandidacy(Long candidate_id, Long candidacy_id) throws CandidateNotFoundException, CandidacyNotFoundException {
        Candidate candidateById = this.candidateService.findCandidateById(candidate_id);
        Candidacy candidacyById = this.candidacyService.findCandidacyById(candidacy_id);
        candidacyById.setCandidate(candidateById);
        candidateById.getCandidacies().add(candidacyById);
    }
}
