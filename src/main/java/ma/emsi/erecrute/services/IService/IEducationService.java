package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Education;
import ma.emsi.erecrute.exceptions.EducationNotFoundException;

import java.util.List;

public interface IEducationService {
    public void addEducation(Education education);
    public void deleteEducation(Long educationId) throws EducationNotFoundException;
    public void updateEducation(Long educationId, Education education) throws EducationNotFoundException;
    public Education findEducationById(Long id) throws EducationNotFoundException;
    public List<Education> getAll();
}
