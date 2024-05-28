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
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professionId;
    private String profession;
    @OneToOne(mappedBy = "profession", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private JobOffer jobOffer;
    @OneToOne(mappedBy = "profession", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Experience experience;
}
