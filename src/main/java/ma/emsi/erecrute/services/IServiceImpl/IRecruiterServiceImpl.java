package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;
import ma.emsi.erecrute.repositories.RecruiterTypeRepository;
import ma.emsi.erecrute.repositories.UserRepository;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IRecruiterServiceImpl implements IRecruiterService {
    private final UserRepository userRepository;

    @Autowired
    public IRecruiterServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addRecruiter(Recruiter recruiter) {
        this.userRepository.save(recruiter);
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
}
