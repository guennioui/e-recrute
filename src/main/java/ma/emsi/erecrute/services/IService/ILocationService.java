package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Location;
import ma.emsi.erecrute.exceptions.LocationNotFoundException;

import java.util.List;

public interface ILocationService {
    public void addLocation(Location location);
    public void deleteLocation(Location location);
    public void updateLocation(Location location);
    public Location findLocationById(Long id) throws LocationNotFoundException;
    public List<Location> getAll();
}
