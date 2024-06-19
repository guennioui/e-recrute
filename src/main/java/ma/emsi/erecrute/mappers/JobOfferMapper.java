package ma.emsi.erecrute.mappers;

import ma.emsi.erecrute.dto.JobOfferDto;
import ma.emsi.erecrute.entites.JobOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JobOfferMapper {
    JobOfferMapper INSTANCE = Mappers.getMapper(JobOfferMapper.class);
    JobOffer JobOfferDtoToJobOffer(JobOfferDto jobOfferDto);
    JobOfferDto JobOfferToJobOfferDto(JobOffer jobOffer);
}
