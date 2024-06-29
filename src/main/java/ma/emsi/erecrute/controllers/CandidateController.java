package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.security.authentication.AuthenticationRequest;
import ma.emsi.erecrute.security.authentication.AuthenticationResponse;
import ma.emsi.erecrute.security.authentication.AuthenticationService;
import ma.emsi.erecrute.security.jwtservice.JwtService;
import ma.emsi.erecrute.services.IService.ICandidateFileService;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.IFileService;
import ma.emsi.erecrute.services.IService.UserRoleService;
import ma.emsi.erecrute.services.IServiceImpl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.RoleNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/candidate")
public class CandidateController {
    private final ICandidateService candidateService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRoleService userRoleService;
    private final FileUploadService fileUploadService;
    private final ICandidateFileService candidateFileService;

    @Autowired
    public CandidateController(ICandidateService candidateService,
                               AuthenticationManager authenticationManager,
                               JwtService jwtService,
                               UserRoleService userRoleService,
                               FileUploadService fileUploadService,
                               ICandidateFileService candidateFileService) {
        this.candidateService = candidateService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRoleService = userRoleService;
        this.fileUploadService = fileUploadService;
        this.candidateFileService = candidateFileService;
    }

    @GetMapping(path = "/home")
    public String home(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
    }

    @PostMapping(path = "/update-profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CandidateDto> updateCandidate(@RequestPart("candidate") CandidateDto candidateDto,
                                                     @RequestPart("candidateImage") MultipartFile image,
                                                     @RequestPart("candidateResume") MultipartFile resume)
            throws IOException,
            CandidateNotFoundException,
            UserNotFoundException,
            RoleNotFoundException {
        Candidate candidate = candidateService.convertToEntity(candidateDto);
        this.candidateService.addCandidate(candidate);
        String imageName = fileUploadService.storeImage(image);
        candidateFileService.addFileToCandidate(candidate.getEmail(), imageName);
        String resumeName= fileUploadService.storePdf(resume);
        candidateFileService.addFileToCandidate(candidate.getEmail(), resumeName);
        return ResponseEntity.ok(candidateDto);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<CandidateDto>> getAll(){
        List<Candidate> candidates = candidateService.getAll();
        List<CandidateDto> candidateDtos = new ArrayList<>();
        for (Candidate candidate : candidates){
            candidateDtos.add(candidateService.convertToDto(candidate));
        }
        return ResponseEntity.ok(candidateDtos);
    }
}
