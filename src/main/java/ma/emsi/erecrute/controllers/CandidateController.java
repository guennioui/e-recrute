package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.services.IService.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/candidate")
public class CandidateController {
    private final ICandidateService candidateService;

    @Autowired
    public CandidateController(ICandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping(path = "/sign-up", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CandidateDto> addCandidate(@RequestPart("candidate") CandidateDto candidateDto,
                                                     @RequestPart("candidateImage")MultipartFile image)
            throws IOException {
        Candidate candidate = candidateService.convertToEntity(candidateDto);
        candidateService.addCandidate(candidate, image);
        return ResponseEntity.ok(candidateDto);
    }
}
