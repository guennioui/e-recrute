package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Education;
import ma.emsi.erecrute.exceptions.EducationNotFoundException;
import ma.emsi.erecrute.repositories.EducationRepository;
import ma.emsi.erecrute.services.IService.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IEducationServiceImpl implements IEducationService {
    private final EducationRepository educationRepository;

    @Autowired
    public IEducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public void addEducation(Education education) {
        this.educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Education education) {
        this.educationRepository.delete(education);
    }

    @Override
    public void updateEducation(Education education) {
        this.educationRepository.save(education);
    }

    @Override
    public Education findEducationById(Long id) throws EducationNotFoundException {
        Optional<Education> optionalEducation = this.educationRepository.findById(id);
        if(optionalEducation.isEmpty()){
            throw new EducationNotFoundException("education not found!");
        }
        return optionalEducation.get();
    }

    @Override
    public List<Education> getAll() {
        return this.educationRepository.findAll();
    }
}
