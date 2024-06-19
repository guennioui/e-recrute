package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.dto.RecruiterDto;
import ma.emsi.erecrute.dto.RegistrationDto;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;
import ma.emsi.erecrute.exceptions.UserNotFoundException;
import ma.emsi.erecrute.mappers.RecruiterMapper;
import ma.emsi.erecrute.mappers.RegistrationMapper;
import ma.emsi.erecrute.repositories.RecruiterTypeRepository;
import ma.emsi.erecrute.repositories.UserRepository;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import ma.emsi.erecrute.services.IService.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IRecruiterServiceImpl implements IRecruiterService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder BCPasswordEncoder;

    @Autowired
    public IRecruiterServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder BCPasswordEncoder) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.BCPasswordEncoder = BCPasswordEncoder;
    }

    @Override
    public void addRecruiter(Recruiter recruiter) throws UserNotFoundException, RoleNotFoundException {
        recruiter.setCreateAt(LocalDateTime.now());
        recruiter.setPassword(BCPasswordEncoder.encode(recruiter.getPassword()));
        this.userRepository.save(recruiter);
        this.userRoleService.addRoleToUser(recruiter.getId(), "RECRUITER");
    }

    @Override
    public void deleteRecruiter(Recruiter recruiter) {
        this.userRepository.delete(recruiter);
    }

    @Override
    public void updateRecruiter(Recruiter recruiter) {
        this.userRepository.save(recruiter);
    }

    @Override
    public Recruiter findRecruiterById(Long id) throws RecruiterNotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new RecruiterNotFoundException("Recruiter not found!");
        }
        return (Recruiter) optionalUser.get();
    }

    @Override
    public List<Recruiter> getAll() {
        return this.userRepository.findAllRecruiters();
    }

    @Override
    public Recruiter convertToEntity(RecruiterDto recruiterDto) {
        return RecruiterMapper.INSTANCE.RecruiterDtoToRecruiter(recruiterDto);
    }

    @Override
    public RecruiterDto convertToDto(Recruiter recruiter) {
        return RecruiterMapper.INSTANCE.RecruiterToRecruiterDto(recruiter);
    }

    @Override
    public Recruiter convertToEntity(RegistrationDto registrationDto) {
        return RegistrationMapper.INSTANCE.RegistrationDtoToRecruiter(registrationDto);
    }
}
