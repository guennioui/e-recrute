package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Location;
import ma.emsi.erecrute.exceptions.LocationNotFoundException;
import ma.emsi.erecrute.repositories.LocationRepository;
import ma.emsi.erecrute.services.IService.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ILocationServiceImpl implements ILocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public ILocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void addLocation(Location location) {
        this.locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        this.locationRepository.delete(location);
    }

    @Override
    public void updateLocation(Location location) {
        this.locationRepository.save(location);
    }

    @Override
    public Location findLocationById(Long id) throws LocationNotFoundException {
        Optional<Location> optionalLocation = this.locationRepository.findById(id);
        if(optionalLocation.isEmpty()){
            throw new LocationNotFoundException("Location not found!");
        }
        return optionalLocation.get();
    }

    @Override
    public List<Location> getAll() {
        return this.locationRepository.findAll();
    }
}
