package ma.emsi.erecrute.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    @OneToOne(
            mappedBy = "location",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE)
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;
}
