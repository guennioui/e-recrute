package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Language;

import java.util.List;

public interface ILanguageService {
    public void addLanguage(Language language);
    public void deleteLanguage(Language language);
    public void updateLanguage(Language language);
    public Language findLanguageById(Long id);
    public List<Language> getAll();
}
