package ma.emsi.erecrute.dto;

import lombok.Data;
import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.JobOffer;
import ma.emsi.erecrute.entites.enums.ApplicationStatus;

import java.time.LocalDate;

@Data
public class CandidacyDto {
    private Long candidacyId;
    private LocalDate appliedDate;
    private ApplicationStatus applicationStatus;
    private CandidateDto candidate;
}
