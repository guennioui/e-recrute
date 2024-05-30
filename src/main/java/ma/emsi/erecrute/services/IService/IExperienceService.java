package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;

import java.util.List;

public interface IExperienceService {
    public void addExperience(Experience experience);
    public void deleteExperience(Long experienceId) throws ExperienceNotFoundException;
    public void updateExperience(Long experienceId, Experience experience) throws ExperienceNotFoundException;
    public Experience findExperienceById(Long id) throws ExperienceNotFoundException;
    public List<Experience> getAll();
}
