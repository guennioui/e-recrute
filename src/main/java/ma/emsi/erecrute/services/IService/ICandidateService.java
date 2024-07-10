package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.dto.RegistrationDto;
import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.RoleNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ICandidateService {
    public void addCandidate(Candidate candidate) throws UserNotFoundException, RoleNotFoundException;
    public void deleteCandidate(Candidate candidate);
    public Candidate updateCandidate(String username,Candidate candidate) throws CandidateNotFoundException;
    public Candidate findCandidateById(Long id) throws CandidateNotFoundException;
    public Candidate findCandidateByEmail(String email) throws CandidateNotFoundException;
    public List<Candidate> getAll();
    public Candidate convertToEntity(CandidateDto candidateDto);
    public CandidateDto convertToDto(Candidate candidate);
    public Candidate convertToEntity(RegistrationDto registrationDto);

}
