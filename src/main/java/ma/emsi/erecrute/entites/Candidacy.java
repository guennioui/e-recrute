package ma.emsi.erecrute.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import ma.emsi.erecrute.entites.enums.ApplicationStatus;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Candidacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidacyId;
    private LocalDate appliedDate;
    private ApplicationStatus applicationStatus;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "jobOffer_id")
    private JobOffer jobOffer;
}
