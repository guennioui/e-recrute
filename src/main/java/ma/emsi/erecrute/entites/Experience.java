package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
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
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experienceId;
    private String title;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @OneToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;
}
