package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.LanguageCandidate;
import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;

import java.util.List;

public interface ILanguageCandidateService {
    public void addLanguageCandidate(LanguageCandidate languageCandidate);
    public void deleteLanguageCandidate(Long languageCandidateId) throws LanguageCandidateNotFoundException;
    public void updateLanguageCandidate(Long languageCandidateId, LanguageCandidate languageCandidate) throws LanguageCandidateNotFoundException;
    public LanguageCandidate findLanguageCandidateById(Long id) throws LanguageCandidateNotFoundException;
    public List<LanguageCandidate> getAll();
}
