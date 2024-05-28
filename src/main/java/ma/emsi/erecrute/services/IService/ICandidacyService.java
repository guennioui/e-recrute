package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Candidacy;

import java.util.List;

public interface ICandidacyService {
    public void addCandidacy(Candidacy candidacy);
    public void deleteCandidacy(Candidacy candidacy);
    public void updateCandidacy(Candidacy candidacy);
    public Candidacy findCandidacyById(Long id);
    public List<Candidacy> getAll();
}
