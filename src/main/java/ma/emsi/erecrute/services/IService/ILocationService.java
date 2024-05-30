package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Location;
import ma.emsi.erecrute.exceptions.LocationNotFoundException;

import java.util.List;

public interface ILocationService {
    public void addLocation(Location location);
    public void deleteLocation(Long locationId) throws LocationNotFoundException;
    public void updateLocation(Long locationId, Location location) throws LocationNotFoundException;
    public Location findLocationById(Long id) throws LocationNotFoundException;
    public List<Location> getAll();
}
