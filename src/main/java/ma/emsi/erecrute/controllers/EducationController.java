package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.EducationDto;
import ma.emsi.erecrute.entites.Education;
import ma.emsi.erecrute.exceptions.EducationNotFoundException;
import ma.emsi.erecrute.services.IService.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/education")
 @CrossOrigin("http://localhost:4200")
public class EducationController {
    private final IEducationService educationService;

    @Autowired
    public EducationController(IEducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping(path = "/add-education")
    public ResponseEntity<EducationDto> addEducation(@RequestBody EducationDto educationDto){
        Education education = new Education();
        education.setInstitution(educationDto.getInstitution());
        education.setDegree(educationDto.getDegree());
        education.setDomain(educationDto.getDomain());
        education.setStartDate(educationDto.getStartDate());
        education.setEndDate(educationDto.getEndDate());
        this.educationService.addEducation(education);
        return ResponseEntity.ok(educationDto);
    }

    @PutMapping(path = "/update/{educationId}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long educationId,
                                                     @RequestBody Education education)
            throws EducationNotFoundException {
        this.educationService.updateEducation(educationId, education);
        return ResponseEntity.ok(education);
    }

    @DeleteMapping(path = "/delete/{educationId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long educationId)
            throws EducationNotFoundException {
        this.educationService.deleteEducation(educationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{educationId}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long educationId)
            throws EducationNotFoundException {
        Education education = this.educationService.findEducationById(educationId);
        return ResponseEntity.ok(education);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Education>> getAll(){
        List<Education> educations = this.educationService.getAll();
        return ResponseEntity.ok(educations);
    }

    @ExceptionHandler(EducationNotFoundException.class)
    public ResponseEntity<String> handleEducationNotFoundException(EducationNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
