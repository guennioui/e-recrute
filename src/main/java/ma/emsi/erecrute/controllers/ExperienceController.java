package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;
import ma.emsi.erecrute.services.IService.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/experience")
public class ExperienceController {
    private final IExperienceService experienceService;

    @Autowired
    public ExperienceController(IExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping(path = "/add-experience")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience){
        this.experienceService.addExperience(experience);
        return ResponseEntity.ok(experience);
    }

    @PutMapping(path = "/update/{experienceId}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long experienceId,
                                             @RequestBody Experience experience)
            throws ExperienceNotFoundException {
        this.experienceService.updateExperience(experienceId, experience);
        return ResponseEntity.ok(experience);
    }

    @DeleteMapping(path = "/delete/{experienceId}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long experienceId)
            throws ExperienceNotFoundException {
        this.experienceService.deleteExperience(experienceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{experienceId}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long experienceId)
            throws ExperienceNotFoundException {
        Experience experience = this.experienceService.findExperienceById(experienceId);
        return ResponseEntity.ok(experience);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Experience>> getAll(){
        List<Experience> all = this.experienceService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(ExperienceNotFoundException.class)
    public ResponseEntity<String> handleExperienceNotFoundException(ExperienceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
