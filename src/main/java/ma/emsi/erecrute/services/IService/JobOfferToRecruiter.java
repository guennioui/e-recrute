package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;

public interface JobOfferToRecruiter {
    public void addJobOfferToRecruiter(Long job_offer_id, Long recruiter_id) throws JobOfferNotFoundException, RecruiterNotFoundException;
}
