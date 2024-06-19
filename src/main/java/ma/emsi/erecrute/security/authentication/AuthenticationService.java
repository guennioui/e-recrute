package ma.emsi.erecrute.security.authentication;

import ma.emsi.erecrute.entites.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    //change to static
    public static Map<String, Object> generateExtraClaims(User user){
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getEmail());
        extraClaims.put("role", user.getRoles());
        return extraClaims;
    }
}
