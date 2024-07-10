package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.CandidacyDto;
import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.enums.ApplicationStatus;
import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.services.IService.CandidateToCandidacy;
import ma.emsi.erecrute.services.IService.ICandidacyService;
import ma.emsi.erecrute.services.IService.JobOfferToCandidacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/candidacy")
public class CandidacyController {
    private final ICandidacyService candidacyService;
    private final CandidateToCandidacy candidateToCandidacy;
    private final JobOfferToCandidacy jobOfferToCandidacy;

    @Autowired
    public CandidacyController(ICandidacyService candidacyService, CandidateToCandidacy candidateToCandidacy, JobOfferToCandidacy jobOfferToCandidacy) {
        this.candidacyService = candidacyService;
        this.candidateToCandidacy = candidateToCandidacy;
        this.jobOfferToCandidacy = jobOfferToCandidacy;
    }

    @PostMapping(path = "/add-candidacy/{username}/{jobOfferId}")
    public ResponseEntity<String> addCandidacy(@PathVariable String username, @PathVariable Long jobOfferId) throws CandidateNotFoundException, CandidacyNotFoundException, JobOfferNotFoundException {
        Candidacy candidacy = new Candidacy();
        candidacy.setAppliedDate(LocalDate.now());
        candidacy.setApplicationStatus(ApplicationStatus.APPLIED);
        candidacyService.addCandidacy(candidacy);
        candidateToCandidacy.addCandidateToCandidacy(username, candidacy.getCandidacyId());
        jobOfferToCandidacy.addJobOfferToCandidacy(jobOfferId, candidacy.getCandidacyId());
        return ResponseEntity.ok("Candidacy applied successfully");
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<CandidacyDto>> getAll(){
        List<CandidacyDto> candidacyDtos = candidacyService.toDtoList(candidacyService.getAll());
        return ResponseEntity.ok(candidacyDtos);
    }

}
