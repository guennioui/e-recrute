package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;

import java.util.List;

public interface IJobOfferService {
    public void addJobOffer(JobOffer jobOffer);
    public void deleteJobOffer(JobOffer jobOffer);
    public void updateJobOffer(JobOffer jobOffer);
    public JobOffer findJobOfferById(Long id) throws JobOfferNotFoundException;
    public List<JobOffer> getAll();
}
