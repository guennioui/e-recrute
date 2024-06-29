package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.File;
import ma.emsi.erecrute.repositories.FileRepository;
import ma.emsi.erecrute.services.IService.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.Optional;

@Service
@Transactional
public class IFileServiceImpl implements IFileService {
    private final FileRepository fileRepository;

    public IFileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void addFile(File file) {
        this.fileRepository.save(file);
    }

    @Override
    public File findFileByName(String fileName) throws FileNotFoundException {
        Optional<File> optionalFile = fileRepository.findByFileName(fileName);
        if(optionalFile.isEmpty()){
            throw new FileNotFoundException("File Not Found Exception");
        }
        return optionalFile.get();
    }
}
