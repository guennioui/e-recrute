package ma.emsi.erecrute.services.IServiceImpl;

import ma.emsi.erecrute.dto.JobOfferDto;
import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.exceptions.JobOfferNotFoundException;
import ma.emsi.erecrute.mappers.JobOfferMapper;
import ma.emsi.erecrute.repositories.JobOfferRepository;
import ma.emsi.erecrute.services.IService.IJobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IJobOfferServiceImpl implements IJobOfferService {
    private JobOfferRepository jobOfferRepository;

    @Autowired
    public IJobOfferServiceImpl(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    @Override
    public void addJobOffer(JobOffer jobOffer) {
        this.jobOfferRepository.save(jobOffer);
    }

    @Override
    public void deleteJobOffer(Long jobOfferId) throws JobOfferNotFoundException {
        JobOffer jobOffer = this.findJobOfferById(jobOfferId);
        this.jobOfferRepository.delete(jobOffer);
    }

    @Override
    public void updateJobOffer(Long jobOfferId, JobOffer jobOffer) throws JobOfferNotFoundException {
        JobOffer jobOfferById = this.findJobOfferById(jobOfferId);
        jobOffer.setJobOfferId(jobOfferId);
        this.jobOfferRepository.save(jobOffer);
    }

    @Override
    public JobOffer findJobOfferById(Long id) throws JobOfferNotFoundException {
        Optional<JobOffer> optionalJobOffer = this.jobOfferRepository.findById(id);
        if(optionalJobOffer.isEmpty()){
            throw new JobOfferNotFoundException("job offer exception!");
        }
        return optionalJobOffer.get();
    }

    @Override
    public List<JobOffer> getAll() {
        return this.jobOfferRepository.findAll();
    }

    @Override
    public JobOffer convertToEntity(JobOfferDto jobOfferDto) {
        return JobOfferMapper.INSTANCE.JobOfferDtoToJobOffer(jobOfferDto);
    }

    @Override
    public JobOfferDto convertToDto(JobOffer jobOffer) {
        return JobOfferMapper.INSTANCE.JobOfferToJobOfferDto(jobOffer);
    }

    @Override
    public List<JobOfferDto> toDtoList(List<JobOffer> jobOffers) {
        return JobOfferMapper.INSTANCE.toDtoList(jobOffers);
    }
}
