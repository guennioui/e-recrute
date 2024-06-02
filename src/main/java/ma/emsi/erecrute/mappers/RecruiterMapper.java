package ma.emsi.erecrute.mappers;

import ma.emsi.erecrute.dto.RecruiterDto;
import ma.emsi.erecrute.entites.Recruiter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecruiterMapper {
    RecruiterMapper INSTANCE = Mappers.getMapper(RecruiterMapper.class);
    RecruiterDto RecruiterToRecruiterDto(Recruiter recruiter);
    Recruiter RecruiterDtoToRecruiter(RecruiterDto recruiter);
}
