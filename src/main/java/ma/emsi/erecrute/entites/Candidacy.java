package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.erecrute.entites.enums.ApplicationStatus;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Candidacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidacyId;
    private LocalDate appliedDate;
    private String coverLetter;
    private ApplicationStatus applicationStatus;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "jobOffer_id")
    private JobOffer jobOffer;
}
