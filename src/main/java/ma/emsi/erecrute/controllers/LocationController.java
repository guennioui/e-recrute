package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.entites.Location;
import ma.emsi.erecrute.exceptions.LocationNotFoundException;
import ma.emsi.erecrute.services.IService.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/location")
public class LocationController {
    private final ILocationService locationService;

    @Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "/add-location")
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        this.locationService.addLocation(location);
        return ResponseEntity.ok(location);
    }

    @PutMapping(path = "/update/{locationId}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long locationId,
                                                   @RequestBody Location location)
            throws LocationNotFoundException{
        this.locationService.updateLocation(locationId, location);
        return ResponseEntity.ok(location);
    }

    @DeleteMapping(path = "/delete/{locationId}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long locationId) throws LocationNotFoundException {
        this.locationService.deleteLocation(locationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long locationId) throws LocationNotFoundException {
        Location location = this.locationService.findLocationById(locationId);
        return ResponseEntity.ok(location);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Location>> getAll(){
        List<Location> all = this.locationService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<String> handleLocationNotFoundException(LocationNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
