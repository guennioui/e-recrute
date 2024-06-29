package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.dto.RegistrationDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.mappers.CandidateMapper;
import ma.emsi.erecrute.mappers.RegistrationMapper;
import ma.emsi.erecrute.repositories.UserRepository;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.RoleNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ICandidateServiceImpl implements ICandidateService {
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;
    @Autowired
    private PasswordEncoder BCPasswordEncoder;
    private final UserRoleService userRoleService;

    @Autowired
    public ICandidateServiceImpl(UserRepository userRepository, FileUploadService fileUploadService, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.fileUploadService = fileUploadService;
        this.userRoleService = userRoleService;
    }

    @Override
    public void addCandidate(Candidate candidate) throws UserNotFoundException, RoleNotFoundException {
        candidate.setCreateAt(LocalDateTime.now());
        candidate.setPassword(BCPasswordEncoder.encode(candidate.getPassword()));
        this.userRepository.save(candidate);
        userRoleService.addRoleToUser(candidate.getId(), "CANDIDATE");
    }

    @Override
    public void updateCandidate(Candidate candidate) throws IOException {
        candidate.setCreateAt(LocalDateTime.now());
        this.userRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(Candidate candidate) {
        this.userRepository.delete(candidate);
    }

    @Override
    public Candidate findCandidateById(Long id) throws CandidateNotFoundException {
        Optional<User> optionalCandidate = userRepository.findById(id);
        if(optionalCandidate.isEmpty()){
            throw new CandidateNotFoundException("candidate not found!");
        }
        return (Candidate) optionalCandidate.get();
    }
    @Override
    public Candidate findCandidateByEmail(String email) throws CandidateNotFoundException {
        Optional<User> optionalCandidate = userRepository.findByEmail(email);
        if(optionalCandidate.isEmpty()){
            throw new CandidateNotFoundException("candidate not found!");
        }
        return (Candidate) optionalCandidate.get();
    }

    @Override
    public List<Candidate> getAll() {
        return this.userRepository.findAllCandidates();
    }

    @Override
    public Candidate convertToEntity(CandidateDto candidateDto) {
        return CandidateMapper.INSTANCE.CandidateDtoToCandidate(candidateDto);
    }

    @Override
    public CandidateDto convertToDto(Candidate candidate) {
        return CandidateMapper.INSTANCE.CandidateToCandidateDto(candidate);
    }

    @Override
    public Candidate convertToEntity(RegistrationDto registrationDto) {
        return RegistrationMapper.INSTANCE.RegistrationDtoToCandidate(registrationDto);
    }
}
