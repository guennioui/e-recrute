package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.dto.CandidacyDto;
import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;

import java.util.List;

public interface ICandidacyService {
    public void addCandidacy(Candidacy candidacy);
    public void deleteCandidacy(Candidacy candidacy);
    public void updateCandidacy(Candidacy candidacy);
    public Candidacy findCandidacyById(Long id) throws CandidacyNotFoundException;
    public List<Candidacy> getAll();
    Candidacy convertToEntity(CandidacyDto candidacyDto);
    CandidacyDto convertToDto(Candidacy candidacy);
}
