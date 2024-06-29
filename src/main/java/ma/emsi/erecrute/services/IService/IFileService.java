package ma.emsi.erecrute.services.IService;


import ma.emsi.erecrute.entites.File;

import java.io.FileNotFoundException;

public interface IFileService {
    public void addFile(File file);
    public File findFileByName(String fileName) throws FileNotFoundException;
}
