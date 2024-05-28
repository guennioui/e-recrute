package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Profession;
import ma.emsi.erecrute.exceptions.ProfessionNotFoundException;
import ma.emsi.erecrute.repositories.ProfessionRepository;
import ma.emsi.erecrute.services.IService.IProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IProfessionServiceImpl implements IProfessionService {
    private final ProfessionRepository professionRepository;

    @Autowired
    public IProfessionServiceImpl(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    @Override
    public void addProfession(Profession profession) {
        this.professionRepository.save(profession);
    }

    @Override
    public void deleteProfession(Profession profession) {
        this.professionRepository.delete(profession);
    }

    @Override
    public void updateProfession(Profession profession) {
        this.professionRepository.save(profession);
    }

    @Override
    public Profession findProfessionById(Long id) throws ProfessionNotFoundException {
        Optional<Profession> optionalProfession = this.professionRepository.findById(id);
        if(optionalProfession.isEmpty()){
            throw new ProfessionNotFoundException("profession not found!");
        }
        return optionalProfession.get();
    }

    @Override
    public List<Profession> getAll() {
        return this.professionRepository.findAll();
    }
}
