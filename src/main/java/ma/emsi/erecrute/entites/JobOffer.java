package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobOfferId;
    private String jobTitle;
    private String jobDescription;
    private String jobType;
    private String requirements;
    private String location;
    private double salary;
    private LocalDate postedDate;
    private LocalDate deadLine;
    private boolean isActive;
    private int views;
    @OneToMany(
            mappedBy = "jobOffer",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Candidacy> candidacies = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;
}
