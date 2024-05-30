package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.RecruiterType;
import ma.emsi.erecrute.exceptions.RecruiterTypeNotFoundException;
import ma.emsi.erecrute.repositories.RecruiterTypeRepository;
import ma.emsi.erecrute.services.IService.IRecruiterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IRecruiterTypeServiceImpl implements IRecruiterTypeService {
    private final RecruiterTypeRepository recruiterTypeRepository;

    @Autowired
    public IRecruiterTypeServiceImpl(RecruiterTypeRepository recruiterTypeRepository) {
        this.recruiterTypeRepository = recruiterTypeRepository;
    }

    @Override
    public void addRecruiterType(RecruiterType recruiterType) {
        this.recruiterTypeRepository.save(recruiterType);
    }

    @Override
    public void deleteRecruiterType(Long recruiterTypeId) throws RecruiterTypeNotFoundException {
        RecruiterType recruiterType = this.findRecruiterTypeById(recruiterTypeId);
        this.recruiterTypeRepository.delete(recruiterType);
    }

    @Override
    public void updateRecruiterType(Long recruiterTypeId, RecruiterType recruiterType) throws RecruiterTypeNotFoundException {
        RecruiterType recruiterTypeById = this.findRecruiterTypeById(recruiterTypeId);
        recruiterTypeById.setRecruiter(recruiterType.getRecruiter());
        recruiterTypeById.setRecruiterType(recruiterType.getRecruiterType());
        this.recruiterTypeRepository.save(recruiterType);
    }

    @Override
    public RecruiterType findRecruiterTypeById(Long id) throws RecruiterTypeNotFoundException {
        Optional<RecruiterType> optionalRecruiterType = this.recruiterTypeRepository.findById(id);
        if(optionalRecruiterType.isEmpty()){
            throw new RecruiterTypeNotFoundException("Recruiter type not found!");
        }
        return optionalRecruiterType.get();
    }

    @Override
    public List<RecruiterType> getAll() {
        return this.recruiterTypeRepository.findAll();
    }
}
