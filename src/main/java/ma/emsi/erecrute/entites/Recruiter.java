package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue("RECRUITER")
@SuperBuilder
public class Recruiter extends User{
    private String companyName;
    private String website;
    private String industry;
    private String companyLogo;
    @OneToMany(
            mappedBy = "recruiter",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<JobOffer> jobOffers = new ArrayList<>();
    @OneToMany(
            mappedBy = "recruiter",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Location> locations = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "recruiter_type_id")
    private RecruiterType recruiterType;

}
