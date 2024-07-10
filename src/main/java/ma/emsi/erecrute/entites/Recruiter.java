package ma.emsi.erecrute.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@DiscriminatorValue("RECRUITER")
public class Recruiter extends User{
    private String companyName;
    private String website;
    private String industry;
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
