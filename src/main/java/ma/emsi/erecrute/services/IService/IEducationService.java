package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Education;
import ma.emsi.erecrute.exceptions.EducationNotFoundException;

import java.util.List;

public interface IEducationService {
    public void addEducation(Education education);
    public void deleteEducation(Education education);
    public void updateEducation(Education education);
    public Education findEducationById(Long id) throws EducationNotFoundException;
    public List<Education> getAll();
}
