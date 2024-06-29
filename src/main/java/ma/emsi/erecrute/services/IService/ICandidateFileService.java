package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidateNotFoundException;

import java.io.FileNotFoundException;

public interface ICandidateFileService {
    public void addFileToCandidate(String username, String fileName) throws CandidateNotFoundException, FileNotFoundException;
}
