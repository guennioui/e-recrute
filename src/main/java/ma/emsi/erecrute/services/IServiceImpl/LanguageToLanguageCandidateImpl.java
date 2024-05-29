package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Language;
import ma.emsi.erecrute.entites.LanguageCandidate;
import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;
import ma.emsi.erecrute.exceptions.LanguageNotFoundException;
import ma.emsi.erecrute.services.IService.ILanguageCandidateService;
import ma.emsi.erecrute.services.IService.ILanguageService;
import ma.emsi.erecrute.services.IService.LanguageToLanguageCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LanguageToLanguageCandidateImpl implements LanguageToLanguageCandidate {
    private final ILanguageService languageService;
    private final ILanguageCandidateService languageCandidateService;

    @Autowired
    public LanguageToLanguageCandidateImpl(ILanguageService languageService, ILanguageCandidateService languageCandidateService) {
        this.languageService = languageService;
        this.languageCandidateService = languageCandidateService;
    }

    @Override
    public void addLanguageToLanguageCandidate(Long language_candidate_id, Long language_id) throws LanguageNotFoundException, LanguageCandidateNotFoundException {
        Language languageById = this.languageService.findLanguageById(language_id);
        LanguageCandidate languageCandidateById = this.languageCandidateService.findLanguageCandidateById(language_candidate_id);
        languageById.getLanguageCandidateList().add(languageCandidateById);
        languageCandidateById.setLanguage(languageById);

    }
}
