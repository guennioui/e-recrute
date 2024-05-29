package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;

public interface JobOfferToCandidacy {
    public void addJobOfferToCandidacy(Long job_offer_id, Long candidacy_id) throws JobOfferNotFoundException, CandidacyNotFoundException;
}
