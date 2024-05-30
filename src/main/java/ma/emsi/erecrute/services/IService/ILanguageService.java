package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Language;
import ma.emsi.erecrute.exceptions.LanguageNotFoundException;

import java.util.List;

public interface ILanguageService {
    public void addLanguage(Language language);
    public void deleteLanguage(Long languageId) throws LanguageNotFoundException;
    public void updateLanguage(Long languageId, Language language) throws LanguageNotFoundException;
    public Language findLanguageById(Long id) throws LanguageNotFoundException;
    public List<Language> getAll();
}
