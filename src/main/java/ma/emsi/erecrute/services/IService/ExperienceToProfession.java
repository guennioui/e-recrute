package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.ExperienceNotFoundException;
import ma.emsi.erecrute.exceptions.ProfessionNotFoundException;

public interface ExperienceToProfession {
    public void addExperienceToProfession(Long experience_id, Long profession_id) throws ExperienceNotFoundException, ProfessionNotFoundException;
}
