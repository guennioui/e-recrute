package ma.emsi.erecrute.mappers;

import ma.emsi.erecrute.dto.RegistrationDto;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Recruiter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationMapper {
    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);
    Candidate RegistrationDtoToCandidate(RegistrationDto registrationDto);
    Recruiter RegistrationDtoToRecruiter(RegistrationDto registrationDto);
}
