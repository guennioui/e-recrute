package ma.emsi.erecrute.services.IServiceImpl;

import lombok.NoArgsConstructor;
import ma.emsi.erecrute.entites.File;
import ma.emsi.erecrute.entites.Image;
import ma.emsi.erecrute.entites.Resume;
import ma.emsi.erecrute.services.IService.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class FileUploadService {
    @Value("${file.upload-image-dir}")
    private String imageUploadDir;
    @Value("${file.upload-pdf-dir}")
    private String pdfUploadDir;
    private final IFileService fileService;

    @Autowired
    public FileUploadService(IFileService fileService) {
        this.fileService = fileService;
    }

    public String storeImage(MultipartFile image) {
        String fileName = UUID.randomUUID().toString() + "-" + image.getOriginalFilename();
        try {
            Path fileStorageLocation = Paths.get(imageUploadDir).toAbsolutePath().normalize();
            Files.createDirectories(fileStorageLocation);
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(image.getInputStream(), targetLocation);
            File file = new Image();
            file.setFileName(fileName);
            file.setSize(image.getSize());
            file.setFilePath(targetLocation.toString());
            fileService.addFile(file);
            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public String storePdf(MultipartFile pdf) {
        String fileName = UUID.randomUUID().toString() + "-" + pdf.getOriginalFilename();
        try {
            Path fileStorageLocation = Paths.get(pdfUploadDir).toAbsolutePath().normalize();
            Files.createDirectories(fileStorageLocation);
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(pdf.getInputStream(), targetLocation);
            File file = new Resume();
            file.setFileName(fileName);
            file.setSize(pdf.getSize());
            file.setFilePath(targetLocation.toString());
            fileService.addFile(file);
            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
