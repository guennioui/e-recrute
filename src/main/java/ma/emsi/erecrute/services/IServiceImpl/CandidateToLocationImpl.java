package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Location;
import ma.emsi.erecrute.exceptions.CandidateNotFoundException;
import ma.emsi.erecrute.exceptions.LocationNotFoundException;
import ma.emsi.erecrute.services.IService.CandidateToLocation;
import ma.emsi.erecrute.services.IService.ICandidateService;
import ma.emsi.erecrute.services.IService.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateToLocationImpl implements CandidateToLocation {
    private final ICandidateService candidateService;
    private final ILocationService locationService;

    @Autowired
    public CandidateToLocationImpl(ICandidateService candidateService, ILocationService locationService) {
        this.candidateService = candidateService;
        this.locationService = locationService;
    }

    @Override
    public void addCandidateToLocation(Long candidate_id, Long location_id) throws CandidateNotFoundException, LocationNotFoundException {
        Candidate candidateById = this.candidateService.findCandidateById(candidate_id);
        Location locationById = this.locationService.findLocationById(location_id);
        candidateById.setLocation(locationById);
        locationById.setCandidate(candidateById);
    }
}
