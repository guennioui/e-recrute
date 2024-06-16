package ma.emsi.erecrute.security.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationResponse {
    private boolean result = false;
    private String jwt;
}
