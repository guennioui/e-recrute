package ma.emsi.erecrute.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String applicationStatus;
}
