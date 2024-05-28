package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;
import ma.emsi.erecrute.repositories.ExperienceRepository;
import ma.emsi.erecrute.services.IService.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IExperienceServiceImpl implements IExperienceService {
    private final ExperienceRepository experienceRepository;

    @Autowired
    public IExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public void addExperience(Experience experience) {
        this.experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Experience experience) {
        this.experienceRepository.delete(experience);
    }

    @Override
    public void updateExperience(Experience experience) {
        this.experienceRepository.save(experience);
    }

    @Override
    public Experience findExperienceById(Long id) throws ExperienceNotFoundException {
        Optional<Experience> optionalExperience = this.experienceRepository.findById(id);
        if(optionalExperience.isEmpty()){
            throw new ExperienceNotFoundException("experience not found!");
        }
        return optionalExperience.get();
    }

    @Override
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }
}
