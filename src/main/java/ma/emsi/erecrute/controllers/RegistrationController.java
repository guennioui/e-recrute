package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.dto.RegistrationDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.security.authentication.AuthenticationResponse;
import ma.emsi.erecrute.security.authentication.AuthenticationService;
import ma.emsi.erecrute.security.jwtservice.JwtService;
import ma.emsi.erecrute.services.IService.ICandidacyService;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import ma.emsi.erecrute.services.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;


@RestController
@RequestMapping(path = "/api/auth")
public class RegistrationController {
    private final ICandidateService candidateService;
    private final IRecruiterService recruiterService;
    private final JwtService jwtService;

    @Autowired
    public RegistrationController(ICandidateService candidateService, IRecruiterService recruiterService, JwtService jwtService) {
        this.candidateService = candidateService;
        this.recruiterService = recruiterService;
        this.jwtService = jwtService;
    }

    @PostMapping(path = "/candidate-registration")
    public ResponseEntity<AuthenticationResponse> CandidateRegistration(@RequestBody RegistrationDto registrationDto) throws UserNotFoundException, RoleNotFoundException {
        Candidate candidate = candidateService.convertToEntity(registrationDto);
        this.candidateService.addCandidate(candidate);
        String token = jwtService.generateToken(candidate, AuthenticationService.generateExtraClaims(candidate));
        return ResponseEntity.ok(new AuthenticationResponse(true, candidate.getEmail(),token));
    }

    @PostMapping(path = "/recruiter-registration")
    public ResponseEntity<AuthenticationResponse> RecruiterRegistration(@RequestBody RegistrationDto registrationDto) throws UserNotFoundException, RoleNotFoundException {
        Recruiter recruiter = recruiterService.convertToEntity(registrationDto);
        this.recruiterService.addRecruiter(recruiter);
        String token = jwtService.generateToken(recruiter, AuthenticationService.generateExtraClaims(recruiter));
        return ResponseEntity.ok(new AuthenticationResponse(true, recruiter.getEmail(),token));
    }
}
