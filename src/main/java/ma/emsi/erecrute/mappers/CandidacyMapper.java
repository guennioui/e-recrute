package ma.emsi.erecrute.mappers;

import ma.emsi.erecrute.dto.CandidacyDto;
import ma.emsi.erecrute.dto.FileDto;
import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.File;
import ma.emsi.erecrute.entites.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CandidacyMapper {
    CandidacyMapper INSTANCE = Mappers.getMapper(CandidacyMapper.class);
    Candidacy CandidacyDtoToCandidacy(CandidacyDto candidacyDto);
    CandidacyDto CandidacyToCandidacyDto(Candidacy candidacy);
    List<CandidacyDto> toDtoList (List<Candidacy> candidacies);
}
