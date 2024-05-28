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
public class RecruiterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RecruiterTypeId;
    private String recruiterType;
    @OneToOne(mappedBy = "recruiterType", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Recruiter recruiter;
}
