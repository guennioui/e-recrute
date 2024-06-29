package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.JobOfferDto;
import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.services.IService.IJobOfferService;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import ma.emsi.erecrute.services.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/job-offer")
public class JobOfferController {
    private final IJobOfferService jobOfferService;
    private final IUserService userService;
    @Autowired
    public JobOfferController(IJobOfferService jobOfferService, IUserService userService) {
        this.jobOfferService = jobOfferService;
        this.userService = userService;
    }

    @PostMapping(path = "/add-job-offer")
    public ResponseEntity<JobOfferDto> addJobOffer(@RequestBody JobOfferDto jobOfferDto) throws UserNotFoundException {
        Recruiter recruiter = (Recruiter) userService.findUserByUsername(jobOfferDto.getRecruiterUsername());
        JobOffer jobOffer = jobOfferService.convertToEntity(jobOfferDto);
        jobOffer.setRecruiter(recruiter);
        this.jobOfferService.addJobOffer(jobOffer);
        return ResponseEntity.ok(jobOfferDto);
    }

    @PutMapping(path = "/update/{jobOfferId}")
    public ResponseEntity<JobOfferDto> updateJobOffer(@PathVariable Long jobOfferId,
                                                       @RequestBody JobOfferDto jobOfferDto)
            throws JobOfferNotFoundException {
        JobOffer jobOffer = this.jobOfferService.convertToEntity(jobOfferDto);
        this.jobOfferService.updateJobOffer(jobOfferId, jobOffer);
        return ResponseEntity.ok(jobOfferDto);
    }                                    
                                         
    @DeleteMapping(path = "/delete/{jobOfferId}")
    public ResponseEntity<Void> deleteJobOffer(@PathVariable Long jobOfferId)
            throws JobOfferNotFoundException {
        this.jobOfferService.deleteJobOffer(jobOfferId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{jobOfferId}")
    public ResponseEntity<JobOffer> getJobOfferById(@PathVariable Long jobOfferId)
            throws JobOfferNotFoundException {
        JobOffer jobOffer = this.jobOfferService.findJobOfferById(jobOfferId);
        return ResponseEntity.ok(jobOffer);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<JobOfferDto>> getAll(){
        List<JobOffer> jobOffers = this.jobOfferService.getAll();
        List<JobOfferDto> jobOfferDtos = new ArrayList<>();
        for (JobOffer jobOffer : jobOffers){
            JobOfferDto jobOfferDto = jobOfferService.convertToDto(jobOffer);
            jobOfferDtos.add(jobOfferDto);
        }
        System.out.println(jobOfferDtos);
        return ResponseEntity.ok(jobOfferDtos);
    }

    @ExceptionHandler(JobOfferNotFoundException.class)
    public ResponseEntity<String> handleJobOfferNotFoundException(JobOfferNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
