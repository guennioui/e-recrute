package ma.emsi.erecrute.services.IService;


import ma.emsi.erecrute.dto.FileDto;
import ma.emsi.erecrute.entites.File;
import ma.emsi.erecrute.entites.Resume;

import java.io.FileNotFoundException;
import java.util.List;

public interface IFileService {
    public void addFile(File file);
    public File findFileByName(String fileName) throws FileNotFoundException;
    public Resume convertToEntity(FileDto fileDto);
    public FileDto convertToDto(Resume file);
}
