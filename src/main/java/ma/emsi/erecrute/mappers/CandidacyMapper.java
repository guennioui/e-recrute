package ma.emsi.erecrute.mappers;

import ma.emsi.erecrute.dto.CandidacyDto;
import ma.emsi.erecrute.entites.Candidacy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidacyMapper {
    CandidacyMapper INSTANCE = Mappers.getMapper(CandidacyMapper.class);
    Candidacy CandidacyDtoToCandidacy(CandidacyDto candidacyDto);
    CandidacyDto CandidacyToCandidacyDto(Candidacy candidacy);
}
