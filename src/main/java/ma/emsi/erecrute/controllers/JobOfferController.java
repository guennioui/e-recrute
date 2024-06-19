package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.JobOfferDto;
import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.services.IService.IJobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/job-offer")
public class JobOfferController {
    private final IJobOfferService jobOfferService;

    @Autowired
    public JobOfferController(IJobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @PostMapping(path = "/add-job-offer")
    public ResponseEntity<JobOfferDto> addJobOffer(@RequestBody JobOfferDto jobOfferDto){
        JobOffer jobOffer = jobOfferService.convertToEntity(jobOfferDto);
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
    public ResponseEntity<List<JobOffer>> getAll(){
        List<JobOffer> all = this.jobOfferService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(JobOfferNotFoundException.class)
    public ResponseEntity<String> handleJobOfferNotFoundException(JobOfferNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
