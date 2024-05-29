package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.entites.Profession;
import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;
import ma.emsi.erecrute.exceptions.ProfessionNotFoundException;
import ma.emsi.erecrute.services.IService.ExperienceToProfession;
import ma.emsi.erecrute.services.IService.IExperienceService;
import ma.emsi.erecrute.services.IService.IProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienceToProfessionImpl implements ExperienceToProfession {
    private final IExperienceService experienceService;
    private final IProfessionService professionService;

    @Autowired
    public ExperienceToProfessionImpl(IExperienceService experienceService, IProfessionService professionService) {
        this.experienceService = experienceService;
        this.professionService = professionService;
    }

    @Override
    public void addExperienceToProfession(Long experience_id, Long profession_id) throws ExperienceNotFoundException, ProfessionNotFoundException {
        Experience experienceById = this.experienceService.findExperienceById(experience_id);
        Profession professionById = this.professionService.findProfessionById(profession_id);
        experienceById.setProfession(professionById);
        professionById.setExperience(experienceById);
    }
}
