package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;
import ma.emsi.erecrute.repositories.CandidacyRepository;
import ma.emsi.erecrute.services.IService.ICandidacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ICandidacyServiceImpl implements ICandidacyService {
    private final CandidacyRepository candidacyRepository;

    @Autowired
    public ICandidacyServiceImpl(CandidacyRepository candidacyRepository) {
        this.candidacyRepository = candidacyRepository;
    }

    @Override
    public void addCandidacy(Candidacy candidacy) {
        this.candidacyRepository.save(candidacy);
    }

    @Override
    public void deleteCandidacy(Candidacy candidacy) {
        this.candidacyRepository.delete(candidacy);
    }

    @Override
    public void updateCandidacy(Candidacy candidacy) {
        this.candidacyRepository.save(candidacy);
    }

    @Override
    public Candidacy findCandidacyById(Long id) throws CandidacyNotFoundException {
        Optional<Candidacy> optionalCandidacy = this.candidacyRepository.findById(id);
        if(optionalCandidacy.isEmpty()){
            throw new CandidacyNotFoundException("candidacy not found!");
        }
        return optionalCandidacy.get();
    }

    @Override
    public List<Candidacy> getAll() {
        return this.candidacyRepository.findAll();
    }
}
