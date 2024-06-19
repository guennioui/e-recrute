package ma.emsi.erecrute.services.IService;

import ma.emsi.erecrute.dto.JobOfferDto;
import ma.emsi.erecrute.entites.Experience;
import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;

import java.util.List;

public interface IJobOfferService {
    public void addJobOffer(JobOffer jobOffer);
    public void deleteJobOffer(Long jobOfferId) throws JobOfferNotFoundException;
    public void updateJobOffer(Long jobOfferId, JobOffer jobOffer)throws JobOfferNotFoundException;
    public JobOffer findJobOfferById(Long id) throws JobOfferNotFoundException;
    public List<JobOffer> getAll();
    public JobOffer convertToEntity(JobOfferDto jobOfferDto);
    public JobOfferDto convertToDto(JobOffer jobOffer);
}
