package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;

import java.util.List;

public interface ICandidateService {
    public void addCandidate(Candidate candidate);
    public void deleteCandidate(Candidate candidate);
    public void updateCandidate(Candidate candidate);
    public Candidate findCandidateById(Long id) throws CandidateNotFoundException;
    public List<Candidate> getAll();
    public Candidate convertToEntity(CandidateDto candidateDto);
    public CandidateDto convertToDto(Candidate candidate);
}
