package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Education;

import java.util.List;

public interface IEducationService {
    public void addEducation(Education education);
    public void deleteEducation(Education education);
    public void updateEducation(Education education);
    public Education findEducationById(Long id);
    public List<Education> getAll();
}
