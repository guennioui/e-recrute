package ma.emsi.erecrute.services.IServiceImpl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@NoArgsConstructor
public class FileUploadService {
    @Value("${file.upload-image-dir}")
    private String imageUploadDir;
    @Value("${file.upload-pdf-dir}")
    private String pdfUploadDir;

    public String storeImage(MultipartFile image) {
        String fileName = UUID.randomUUID().toString() + "-" + image.getOriginalFilename();
        try {
            Path fileStorageLocation = Paths.get(imageUploadDir).toAbsolutePath().normalize();
            Files.createDirectories(fileStorageLocation);
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(image.getInputStream(), targetLocation);
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
            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
