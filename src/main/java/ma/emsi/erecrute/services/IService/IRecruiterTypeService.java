package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.RecruiterType;
import ma.emsi.erecrute.exceptions.RecruiterTypeNotFoundException;

import java.util.List;

public interface IRecruiterTypeService {
    public void addRecruiterType(RecruiterType recruiterType);
    public void deleteRecruiterType(Long recruiterTypeId) throws RecruiterTypeNotFoundException;
    public void updateRecruiterType(Long recruiterTypeId, RecruiterType recruiterType) throws RecruiterTypeNotFoundException;
    public RecruiterType findRecruiterTypeById(Long id) throws RecruiterTypeNotFoundException;
    public List<RecruiterType> getAll();
}
