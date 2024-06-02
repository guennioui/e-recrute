package ma.emsi.erecrute.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CandidateDto {
    private String civility;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String telephone;
    private LocalDateTime createAt;
    private LocalDate dateOfBirth;
}
