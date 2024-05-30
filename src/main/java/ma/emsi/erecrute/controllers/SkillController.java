package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.entites.Skill;
import ma.emsi.erecrute.exceptions.SkillNotFoundException;
import ma.emsi.erecrute.services.IService.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/skill")
public class SkillController {
    private final ISkillService skillService;
    @Autowired
    public SkillController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping(path = "/add-skill")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill){
        this.skillService.addSkill(skill);
        return ResponseEntity.ok(skill);
    }

    @PutMapping(path = "/update/{skillId}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long skillId,
                                                   @RequestBody Skill skill)
            throws SkillNotFoundException {
        this.skillService.updateSkill(skillId, skill);
        return ResponseEntity.ok(skill);
    }

    @DeleteMapping(path = "/delete/{skillId}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long skillId)
            throws SkillNotFoundException {
        this.skillService.deleteSkill(skillId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{skillId}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long skillId)
            throws SkillNotFoundException {
        Skill skill = this.skillService.findSkillById(skillId);
        return ResponseEntity.ok(skill);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Skill>> getAll(){
        List<Skill> all = this.skillService.getAll();
        return ResponseEntity.ok(all);
    }

    @ExceptionHandler(SkillNotFoundException.class)
    public ResponseEntity<String> handleSkillNotFoundException(SkillNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
