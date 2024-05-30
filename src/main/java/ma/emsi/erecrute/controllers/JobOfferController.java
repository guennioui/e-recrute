package ma.emsi.erecrute.controllers;

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
    public ResponseEntity<JobOffer> addJobOffer(@RequestBody JobOffer jobOffer){
        this.jobOfferService.addJobOffer(jobOffer);
        return ResponseEntity.ok(jobOffer);
    }

    @PutMapping(path = "/update/{jobOfferId}")
    public ResponseEntity<JobOffer> updateJobOffer(@PathVariable Long jobOfferId,
                                                       @RequestBody JobOffer jobOffer)
            throws JobOfferNotFoundException {
        this.jobOfferService.updateJobOffer(jobOfferId, jobOffer);
        return ResponseEntity.ok(jobOffer);
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
