package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.LanguageCandidate;
import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;

import java.util.List;

public interface ILanguageCandidateService {
    public void addLanguageCandidate(LanguageCandidate languageCandidate);
    public void deleteLanguageCandidate(LanguageCandidate languageCandidate);
    public void updateLanguageCandidate(LanguageCandidate languageCandidate);
    public LanguageCandidate findLanguageCandidateById(Long id) throws LanguageCandidateNotFoundException;
    public List<LanguageCandidate> getAll();
}
