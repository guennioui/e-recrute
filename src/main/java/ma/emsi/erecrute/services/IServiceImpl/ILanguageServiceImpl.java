package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Language;
import ma.emsi.erecrute.exceptions.LanguageNotFoundException;
import ma.emsi.erecrute.repositories.LanguageRepository;
import ma.emsi.erecrute.services.IService.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ILanguageServiceImpl implements ILanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public ILanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void addLanguage(Language language) {
        this.languageRepository.save(language);
    }

    @Override
    public void deleteLanguage(Language language) {
        this.languageRepository.delete(language);
    }

    @Override
    public void updateLanguage(Language language) {
        this.languageRepository.save(language);
    }

    @Override
    public Language findLanguageById(Long id) throws LanguageNotFoundException {
        Optional<Language> optionalLanguage = this.languageRepository.findById(id);
        if(optionalLanguage.isEmpty()){
            throw new LanguageNotFoundException("Language not found!");
        }
        return optionalLanguage.get();
    }

    @Override
    public List<Language> getAll() {
        return this.languageRepository.findAll();
    }
}
