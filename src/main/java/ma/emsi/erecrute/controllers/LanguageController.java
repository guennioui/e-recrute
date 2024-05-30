package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.entites.Language;
import ma.emsi.erecrute.exceptions.LanguageNotFoundException;
import ma.emsi.erecrute.services.IService.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/language")
public class LanguageController {
    private final ILanguageService languageService;

    @Autowired
    public LanguageController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping(path = "/add-language")
    public ResponseEntity<Language> addLanguage(@RequestBody Language language){
        this.languageService.addLanguage(language);
        return ResponseEntity.ok(language);
    }

    @PutMapping(path = "/update/{languageId}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long languageId,
                                                   @RequestBody Language language)
            throws LanguageNotFoundException {
        this.languageService.updateLanguage(languageId, language);
        return ResponseEntity.ok(language);
    }

    @DeleteMapping(path = "/delete/{languageId}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long languageId)
            throws LanguageNotFoundException {
        this.languageService.deleteLanguage(languageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{languageId}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long languageId)
            throws LanguageNotFoundException {
        Language language = this.languageService.findLanguageById(languageId);
        return ResponseEntity.ok(language);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Language>> getAll(){
        List<Language> all = this.languageService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(LanguageNotFoundException.class)
    public ResponseEntity<String> handleLanguageNotFoundException(LanguageNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
