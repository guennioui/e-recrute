package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.LanguageCandidate;
import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;
import ma.emsi.erecrute.repositories.LanguageCandidateRepository;
import ma.emsi.erecrute.services.IService.ILanguageCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ILanguageCandidateServiceImpl implements ILanguageCandidateService {
    private final LanguageCandidateRepository languageCandidateRepository;

    @Autowired
    public ILanguageCandidateServiceImpl(LanguageCandidateRepository languageCandidateRepository) {
        this.languageCandidateRepository = languageCandidateRepository;
    }

    @Override
    public void addLanguageCandidate(LanguageCandidate languageCandidate) {
        this.languageCandidateRepository.save(languageCandidate);
    }

    @Override
    public void deleteLanguageCandidate(LanguageCandidate languageCandidate) {
        this.languageCandidateRepository.delete(languageCandidate);
    }

    @Override
    public void updateLanguageCandidate(LanguageCandidate languageCandidate) {
        this.languageCandidateRepository.save(languageCandidate);
    }

    @Override
    public LanguageCandidate findLanguageCandidateById(Long id) throws LanguageCandidateNotFoundException {
        Optional<LanguageCandidate> optionalLanguageCandidate = this.languageCandidateRepository.findById(id);
        if(optionalLanguageCandidate.isEmpty()){
            throw new LanguageCandidateNotFoundException("Language Candidate Not Found!");
        }
        return optionalLanguageCandidate.get();
    }

    @Override
    public List<LanguageCandidate> getAll() {
        return this.languageCandidateRepository.findAll();
    }
}
