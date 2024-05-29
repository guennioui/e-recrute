package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;
import ma.emsi.erecrute.exceptions.RecruiterTypeNotFoundException;

public interface RecruiterToRecruiterType {
    public void addRecruiterToRecruiterType(Long recruiter_id, Long recruiter_type_id) throws RecruiterNotFoundException, RecruiterTypeNotFoundException;
}
