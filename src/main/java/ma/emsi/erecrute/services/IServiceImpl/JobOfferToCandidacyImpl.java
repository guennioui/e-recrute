package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.exceptions.CandidacyNotFoundException;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.services.IService.ICandidacyService;
import ma.emsi.erecrute.services.IService.IJobOfferService;
import ma.emsi.erecrute.services.IService.JobOfferToCandidacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobOfferToCandidacyImpl implements JobOfferToCandidacy {
    private final IJobOfferService jobOfferService;
    private final ICandidacyService candidacyService;

    @Autowired
    public JobOfferToCandidacyImpl(IJobOfferService jobOfferService, ICandidacyService candidacyService) {
        this.jobOfferService = jobOfferService;
        this.candidacyService = candidacyService;
    }

    @Override
    public void addJobOfferToCandidacy(Long job_offer_id, Long candidacy_id) throws JobOfferNotFoundException, CandidacyNotFoundException {
        JobOffer jobOfferById = this.jobOfferService.findJobOfferById(job_offer_id);
        Candidacy candidacyById = this.candidacyService.findCandidacyById(candidacy_id);
        jobOfferById.getCandidacies().add(candidacyById);
        candidacyById.setJobOffer(jobOfferById);
    }
}
