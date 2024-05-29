package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.LanguageCandidate;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;
import ma.emsi.erecrute.services.IService.CandidateToLanguageCandidate;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.ILanguageCandidateService;
import ma.emsi.erecrute.services.IService.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateToLanguageCandidateImpl implements CandidateToLanguageCandidate {
    private final ICandidateService candidateService;
    private final ILanguageCandidateService languageCandidateService;

    @Autowired
    public CandidateToLanguageCandidateImpl(ICandidateService candidateService, ILanguageCandidateService languageCandidateService) {
        this.candidateService = candidateService;
        this.languageCandidateService = languageCandidateService;
    }

    @Override
    public void addCandidateToLanguageCandidate(Long language_candidate_id, Long candidate_id) throws CandidateNotFoundException, LanguageCandidateNotFoundException {
        Candidate candidateById = this.candidateService.findCandidateById(candidate_id);
        LanguageCandidate languageCandidateById = this.languageCandidateService.findLanguageCandidateById(language_candidate_id);
        candidateById.getLanguageCandidates().add(languageCandidateById);
        languageCandidateById.setCandidate(candidateById);

    }
}
