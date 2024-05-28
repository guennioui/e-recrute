package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue("CANDIDATE")
@SuperBuilder
public class Candidate extends User{
    private LocalDate dateOfBirth;
    private String image;
    private String resume;
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
    @JoinColumn(name = "candidate_id")
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
