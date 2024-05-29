package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Location;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.exceptions.LocationNotFoundException;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;
import ma.emsi.erecrute.services.IService.ILocationService;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import ma.emsi.erecrute.services.IService.RecruiterToLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecruiterToLocationImpl implements RecruiterToLocation {
    private final IRecruiterService recruiterService;
    private final ILocationService locationService;

    @Autowired
    public RecruiterToLocationImpl(IRecruiterService recruiterService, ILocationService locationService) {
        this.recruiterService = recruiterService;
        this.locationService = locationService;
    }

    @Override
    public void addRecruiterToLocation(Long recruiter_id, Long location_id) throws RecruiterNotFoundException, LocationNotFoundException {
        Recruiter recruiterById = this.recruiterService.findRecruiterById(recruiter_id);
        Location locationById = this.locationService.findLocationById(location_id);
        recruiterById.getLocations().add(locationById);
        locationById.setRecruiter(recruiterById);
    }
}
