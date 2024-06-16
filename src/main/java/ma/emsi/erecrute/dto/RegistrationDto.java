package ma.emsi.erecrute.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationDto {
    private String civility;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String telephone;
}
