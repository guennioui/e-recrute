package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Skill;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.SkillNotFoundException;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.security.jwtservice.JwtService;
import ma.emsi.erecrute.services.IService.*;
import ma.emsi.erecrute.services.IServiceImpl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    private final ISkillService skillService;
    private final CandidateToSkill candidateToSkill;
    @Autowired
    public CandidateController(ICandidateService candidateService,
                               AuthenticationManager authenticationManager,
                               JwtService jwtService,
                               UserRoleService userRoleService,
                               FileUploadService fileUploadService,
                               ICandidateFileService candidateFileService,
                               ISkillService skillService,
                               CandidateToSkill candidateToSkill) {
        this.candidateService = candidateService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRoleService = userRoleService;
        this.fileUploadService = fileUploadService;
        this.candidateFileService = candidateFileService;
        this.skillService = skillService;
        this.candidateToSkill = candidateToSkill;
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
            RoleNotFoundException,
            SkillNotFoundException {
        Candidate candidate = candidateService.convertToEntity(candidateDto);
        candidate = this.candidateService.updateCandidate(candidate.getEmail(), candidate);
        for (String skill : candidateDto.getSkills()){
            Skill skill1 = new Skill();
            skill1.setName(skill);
            skill1.setCandidate(candidate);
            skillService.addSkill(skill1);
            candidateToSkill.addCandidateToSkill(candidate.getId(), skill1.getSkillId());
        }
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
