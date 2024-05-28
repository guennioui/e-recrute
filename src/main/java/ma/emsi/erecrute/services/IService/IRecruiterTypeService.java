package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.RecruiterType;
import ma.emsi.erecrute.exceptions.RecruiterTypeNotFoundException;

import java.util.List;

public interface IRecruiterTypeService {
    public void addRecruiterType(RecruiterType recruiterType);
    public void deleteRecruiterType(RecruiterType recruiterType);
    public void updateRecruiterType(RecruiterType recruiterType);
    public RecruiterType findRecruiterTypeById(Long id) throws RecruiterTypeNotFoundException;
    public List<RecruiterType> getAll();
}
