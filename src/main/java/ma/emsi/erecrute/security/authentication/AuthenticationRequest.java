package ma.emsi.erecrute.security.authentication;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
