package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.entites.Profession;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.exceptions.ProfessionNotFoundException;
import ma.emsi.erecrute.services.IService.IJobOfferService;
import ma.emsi.erecrute.services.IService.IProfessionService;
import ma.emsi.erecrute.services.IService.JobOfferToProfession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobOfferToProfessionImpl implements JobOfferToProfession {
    private final IJobOfferService jobOfferService;
    private final IProfessionService professionService;

    @Autowired
    public JobOfferToProfessionImpl(IJobOfferService jobOfferService, IProfessionService professionService) {
        this.jobOfferService = jobOfferService;
        this.professionService = professionService;
    }

    @Override
    public void addJobOfferToProfession(Long job_offer_id, Long profession_id) throws JobOfferNotFoundException, ProfessionNotFoundException {
        JobOffer jobOfferById = this.jobOfferService.findJobOfferById(job_offer_id);
        Profession professionById = this.professionService.findProfessionById(profession_id);
        jobOfferById.setProfession(professionById);
        professionById.setJobOffer(jobOfferById);

    }
}
