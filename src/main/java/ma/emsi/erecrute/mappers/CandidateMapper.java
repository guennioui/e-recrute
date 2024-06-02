package ma.emsi.erecrute.mappers;

import ma.emsi.erecrute.dto.CandidateDto;
import ma.emsi.erecrute.entites.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidateMapper {
    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);
    CandidateDto CandidateToCandidateDto(Candidate candidate);
    Candidate CandidateDtoToCandidate(CandidateDto candidateDto);
}
