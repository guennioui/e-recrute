package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Location;

import java.util.List;

public interface ILocationService {
    public void addLocation(Location location);
    public void deleteLocation(Location location);
    public void updateLocation(Location location);
    public Location findLocationById(Long id);
    public List<Location> getAll();
}
