package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.LocationNotFoundException;

public interface CandidateToLocation {
    public void addCandidateToLocation(Long candidate_id, Long location_id) throws CandidateNotFoundException, LocationNotFoundException;
}
