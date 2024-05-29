package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.LocationNotFoundException;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;

public interface RecruiterToLocation {
    public void addRecruiterToLocation(Long recruiter_id, Long location_id) throws RecruiterNotFoundException, LocationNotFoundException;
}
