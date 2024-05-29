package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.exceptions.ProfessionNotFoundException;

public interface JobOfferToProfession {
    public void addJobOfferToProfession(Long Job_offer_id, Long profession_id) throws JobOfferNotFoundException, ProfessionNotFoundException;
}
