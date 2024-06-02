package ma.emsi.erecrute.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RecruiterDto {
    private String civility;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String telephone;
    private LocalDateTime createAt;
    private String companyName;
}
