package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.repositories.CandidacyRepository;
import ma.emsi.erecrute.repositories.UserRepository;
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
    private final UserRepository userRepository;
    private final CandidacyRepository candidacyRepository;

    @Autowired
    public CandidateToCandidacyImpl(ICandidateService candidateService, ICandidacyService candidacyService, UserRepository userRepository, CandidacyRepository candidacyRepository) {
        this.candidateService = candidateService;
        this.candidacyService = candidacyService;
        this.userRepository = userRepository;
        this.candidacyRepository = candidacyRepository;
    }

    @Override
    public void addCandidateToCandidacy(String username, Long candidacy_id) throws CandidateNotFoundException, CandidacyNotFoundException {
        Candidate candidateById = this.candidateService.findCandidateByEmail(username);
        Candidacy candidacyById = this.candidacyService.findCandidacyById(candidacy_id);
        candidacyById.setCandidate(candidateById);
        candidateById.getCandidacies().add(candidacyById);
        userRepository.save(candidateById);
        candidacyRepository.save(candidacyById);
    }
}
