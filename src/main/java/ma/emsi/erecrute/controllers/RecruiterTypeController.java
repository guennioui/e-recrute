package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.entites.RecruiterType;
import ma.emsi.erecrute.exceptions.RecruiterTypeNotFoundException;
import ma.emsi.erecrute.services.IService.IRecruiterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recruiter-type")
public class RecruiterTypeController {
    private final IRecruiterTypeService recruiterTypeService;

    @Autowired
    public RecruiterTypeController(IRecruiterTypeService recruiterTypeService) {
        this.recruiterTypeService = recruiterTypeService;
    }

    @PostMapping(path = "/add-recruiter-type")
    public ResponseEntity<RecruiterType> addRecruiterType(@RequestBody RecruiterType recruiterType){
        this.recruiterTypeService.addRecruiterType(recruiterType);
        return ResponseEntity.ok(recruiterType);
    }

    @PutMapping(path = "/update/{recruiterTypeId}")
    public ResponseEntity<RecruiterType> updateRecruiterType(@PathVariable Long recruiterTypeId,
                                                   @RequestBody RecruiterType recruiterType)
            throws RecruiterTypeNotFoundException {
        this.recruiterTypeService.updateRecruiterType(recruiterTypeId, recruiterType);
        return ResponseEntity.ok(recruiterType);
    }

    @DeleteMapping(path = "/delete/{recruiterTypeId}")
    public ResponseEntity<Void> deleteRecruiterType(@PathVariable Long recruiterTypeId)
            throws RecruiterTypeNotFoundException {
        this.recruiterTypeService.deleteRecruiterType(recruiterTypeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{recruiterTypeId}")
    public ResponseEntity<RecruiterType> getRecruiterTypeById(@PathVariable Long recruiterTypeId)
            throws RecruiterTypeNotFoundException {
        RecruiterType recruiterType = this.recruiterTypeService.findRecruiterTypeById(recruiterTypeId);
        return ResponseEntity.ok(recruiterType);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<RecruiterType>> getAll(){
        List<RecruiterType> all = this.recruiterTypeService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(RecruiterTypeNotFoundException.class)
    public ResponseEntity<String> handleLocationNotFoundException(RecruiterTypeNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
