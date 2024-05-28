package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.entites.JobOffer;

import java.util.List;

public interface IJobOfferService {
    public void addJobOffer(JobOffer jobOffer);
    public void deleteJobOffer(JobOffer jobOffer);
    public void updateJobOffer(JobOffer jobOffer);
    public JobOffer findJobOfferById(Long id);
    public List<JobOffer> getAll();
}
