package ma.emsi.erecrute.security.jwtservice;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import ma.emsi.erecrute.entites.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;
    @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;
    public String generateToken(User user, Map<String, Object> extraClaims){

        LocalDate currentDate = LocalDate.now();
        Date issuedAt = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date expiration = Date.from(currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        String jwtToken = Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();
        return jwtToken;
    }

    private Key generateKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String extractUsername(String jwt){
        return extractAllClaims(jwt).getSubject();
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(generateKey()).build()
                .parseClaimsJws(jwt)
                .getBody();
    }
}
