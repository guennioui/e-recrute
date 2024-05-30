package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.entites.LanguageCandidate;
import ma.emsi.erecrute.exceptions.LanguageCandidateNotFoundException;
import ma.emsi.erecrute.services.IService.ILanguageCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/language-candidate")
public class LanguageCandidateController {
    private final ILanguageCandidateService languageCandidateService;

    @Autowired
    public LanguageCandidateController(ILanguageCandidateService languageCandidateService) {
        this.languageCandidateService = languageCandidateService;
    }

    @PostMapping(path = "/add-language-candidate")
    public ResponseEntity<LanguageCandidate> addLanguageCandidate(@RequestBody LanguageCandidate languageCandidate){
        this.languageCandidateService.addLanguageCandidate(languageCandidate);
        return ResponseEntity.ok(languageCandidate);
    }

    @PutMapping(path = "/update/{languageCandidateId}")
    public ResponseEntity<LanguageCandidate> updateLanguageCandidate(@PathVariable Long languageCandidateId,
                                                   @RequestBody LanguageCandidate languageCandidate)
            throws LanguageCandidateNotFoundException {
        this.languageCandidateService.updateLanguageCandidate(languageCandidateId, languageCandidate);
        return ResponseEntity.ok(languageCandidate);
    }

    @DeleteMapping(path = "/delete/{languageCandidateId}")
    public ResponseEntity<Void> deleteLanguageCandidate(@PathVariable Long languageCandidateId)
            throws LanguageCandidateNotFoundException {
        this.languageCandidateService.deleteLanguageCandidate(languageCandidateId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{languageCandidateId}")
    public ResponseEntity<LanguageCandidate> getLanguageCandidateById(@PathVariable Long languageCandidateId)
            throws LanguageCandidateNotFoundException {
        LanguageCandidate languageCandidate = this.languageCandidateService.findLanguageCandidateById(languageCandidateId);
        return ResponseEntity.ok(languageCandidate);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<LanguageCandidate>> getAll(){
        List<LanguageCandidate> all = this.languageCandidateService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(LanguageCandidateNotFoundException.class)
    public ResponseEntity<String> handleLanguageCandidateNotFoundException(LanguageCandidateNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
