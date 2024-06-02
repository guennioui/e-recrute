package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.RecruiterDto;
import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recruiter")
public class RecruiterController {
    private final IRecruiterService recruiterService;

    @Autowired
    public RecruiterController(IRecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping(path = "/sign-up")
    public ResponseEntity<RecruiterDto> addRecruiter(@RequestBody RecruiterDto recruiterDto){
        Recruiter recruiter = recruiterService.convertToEntity(recruiterDto);
        this.recruiterService.addRecruiter(recruiter);
        return ResponseEntity.ok(recruiterDto);
    }

}
