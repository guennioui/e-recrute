package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.entites.Profession;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;
import ma.emsi.erecrute.exceptions.ProfessionNotFoundException;
import ma.emsi.erecrute.services.IService.IProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/profession")
public class ProfessionController {
    private final IProfessionService professionService;

    @Autowired
    public ProfessionController(IProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping(path = "/add-profession")
    public ResponseEntity<Profession> addProfession(@RequestBody Profession profession){
        this.professionService.addProfession(profession);
        return ResponseEntity.ok(profession);
    }

    @PutMapping(path = "/update/{professionId}")
    public ResponseEntity<Profession> updateProfession(@PathVariable Long professionId,
                                                       @RequestBody Profession profession)
            throws ProfessionNotFoundException {
        this.professionService.updateProfession(professionId, profession);
        return ResponseEntity.ok(profession);
    }

    @DeleteMapping(path = "/delete/{professionId}")
    public ResponseEntity<Void> deleteProfession(@PathVariable Long professionId)
            throws ProfessionNotFoundException {
        this.professionService.deleteProfession(professionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{professionId}")
    public ResponseEntity<Profession> getProfessionById(@PathVariable Long professionId)
            throws ProfessionNotFoundException {
        Profession profession = this.professionService.findProfessionById(professionId);
        return ResponseEntity.ok(profession);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Profession>> getAll(){
        List<Profession> all = this.professionService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(ProfessionNotFoundException.class)
    public ResponseEntity<String> handleProfessionNotFoundException(ProfessionNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
