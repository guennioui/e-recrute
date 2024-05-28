package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.Candidate;

import java.util.List;

public interface ICandidateService {
    public void addCandidate(Candidate candidate);
    public void deleteCandidate(Candidate candidate);
    public void updateCandidate(Candidate candidate);
    public Candidate findCandidateById(Long id);
    public List<Candidate> getAll();
}
