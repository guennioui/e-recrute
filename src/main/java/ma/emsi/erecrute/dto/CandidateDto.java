package ma.emsi.erecrute.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CandidateDto {
    private String civility;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String telephone;
    private String linkedInUrl;
    private String resume;
    private String nationality;
    private LocalDate dateOfBirth;
    private String[] skills;
    private List<FileDto> files = new ArrayList<>();
}
