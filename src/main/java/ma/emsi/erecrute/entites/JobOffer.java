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
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String jobOfferId;
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
}
