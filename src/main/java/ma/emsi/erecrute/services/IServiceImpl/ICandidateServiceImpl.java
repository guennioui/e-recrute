package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.repositories.UserRepository;
import ma.emsi.erecrute.services.IService.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ICandidateServiceImpl implements ICandidateService {
    private final UserRepository userRepository;

    @Autowired
    public ICandidateServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addCandidate(Candidate candidate) {
        this.userRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(Candidate candidate) {
        this.userRepository.delete(candidate);
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        this.userRepository.save(candidate);
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
    public List<Candidate> getAll() {
        return this.userRepository.findAllCandidates();
    }
}
