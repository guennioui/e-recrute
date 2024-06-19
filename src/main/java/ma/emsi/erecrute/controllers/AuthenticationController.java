package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.security.authentication.AuthenticationRequest;
import ma.emsi.erecrute.security.authentication.AuthenticationResponse;
import ma.emsi.erecrute.security.authentication.AuthenticationService;
import ma.emsi.erecrute.security.jwtservice.JwtService;
import ma.emsi.erecrute.services.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthenticationController {
    private final IUserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationController(IUserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);
        User user = userService.findUserByUsername(request.getUsername());
        String jwt = jwtService.generateToken(user, AuthenticationService.generateExtraClaims(user));
        return ResponseEntity.ok(new AuthenticationResponse(true, jwt));
    }
}
