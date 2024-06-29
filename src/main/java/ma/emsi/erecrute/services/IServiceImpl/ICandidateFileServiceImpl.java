package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.File;
import ma.emsi.erecrute.entites.User;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.repositories.FileRepository;
import ma.emsi.erecrute.repositories.UserRepository;
import ma.emsi.erecrute.services.IService.ICandidateFileService;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.IFileService;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
@Transactional
public class ICandidateFileServiceImpl implements ICandidateFileService {
    private final IFileService fileService;
    private final ICandidateService candidateService;
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    @Autowired
    public ICandidateFileServiceImpl(IFileService fileService, ICandidateService candidateService, FileRepository fileRepository, UserRepository userRepository) {
        this.fileService = fileService;
        this.candidateService = candidateService;
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addFileToCandidate(String username, String fileName) throws CandidateNotFoundException, FileNotFoundException {
        User user = candidateService.findCandidateByEmail(username);
        File file = fileService.findFileByName(fileName);
        user.getFiles().add(file);
        file.setUser(user);
        fileRepository.save(file);
        userRepository.save(user);
    }
}
