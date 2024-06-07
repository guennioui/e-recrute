package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.mappers.CandidateMapper;
import ma.emsi.erecrute.repositories.UserRepository;
import ma.emsi.erecrute.services.IService.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ICandidateServiceImpl implements ICandidateService {
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    public ICandidateServiceImpl(UserRepository userRepository, FileUploadService fileUploadService) {
        this.userRepository = userRepository;
        this.fileUploadService = fileUploadService;
    }

    @Override
    public void addCandidate(Candidate candidate, MultipartFile image) throws IOException {
        candidate.setCreateAt(LocalDateTime.now());
        String imageURL = this.fileUploadService.storeImage(image);
        candidate.setImage(imageURL);
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

    @Override
    public Candidate convertToEntity(CandidateDto candidateDto) {
        return CandidateMapper.INSTANCE.CandidateDtoToCandidate(candidateDto);
    }

    @Override
    public CandidateDto convertToDto(Candidate candidate) {
        return CandidateMapper.INSTANCE.CandidateToCandidateDto(candidate);
    }
}
