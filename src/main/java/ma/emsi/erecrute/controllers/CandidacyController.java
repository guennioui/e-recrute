package ma.emsi.erecrute.controllers;

import ma.emsi.erecrute.services.IService.ICandidacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/candidacy")
public class CandidacyController {
    private final ICandidacyService candidacyService;

    @Autowired
    public CandidacyController(ICandidacyService candidacyService) {
        this.candidacyService = candidacyService;
    }
}
