package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@DiscriminatorValue("CANDIDATE")
public class Candidate extends User{
    private LocalDate dateOfBirth;
    private String nationality;
    @OneToMany(
            mappedBy = "candidate",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<LanguageCandidate> languageCandidates = new ArrayList<>();
    @OneToMany(
            mappedBy = "candidate",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<Education> educations = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(
            mappedBy = "candidate",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Experience> experiences = new ArrayList<>();
    @OneToMany(
            mappedBy = "candidate",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Skill> skills = new ArrayList<>();
    @OneToMany(
            mappedBy = "candidate",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Candidacy> candidacies = new ArrayList<>();
}
