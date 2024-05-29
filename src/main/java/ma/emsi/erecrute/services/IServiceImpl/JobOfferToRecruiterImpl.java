package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.exceptions.RecruiterNotFoundException;
import ma.emsi.erecrute.services.IService.IJobOfferService;
import ma.emsi.erecrute.services.IService.IRecruiterService;
import ma.emsi.erecrute.services.IService.JobOfferToProfession;
import ma.emsi.erecrute.services.IService.JobOfferToRecruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobOfferToRecruiterImpl implements JobOfferToRecruiter {
    private final IJobOfferService jobOfferService;
    private final IRecruiterService recruiterService;

    @Autowired
    public JobOfferToRecruiterImpl(IJobOfferService jobOfferService, IRecruiterService recruiterService) {
        this.jobOfferService = jobOfferService;
        this.recruiterService = recruiterService;
    }

    @Override
    public void addJobOfferToRecruiter(Long job_offer_id, Long recruiter_id) throws JobOfferNotFoundException, RecruiterNotFoundException {
        JobOffer jobOfferById = this.jobOfferService.findJobOfferById(job_offer_id);
        Recruiter recruiterById = this.recruiterService.findRecruiterById(recruiter_id);
        recruiterById.getJobOffers().add(jobOfferById);
        jobOfferById.setRecruiter(recruiterById);
    }
}
