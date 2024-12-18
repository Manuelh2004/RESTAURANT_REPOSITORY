package sistema.sistema.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

@Service
public class JWTService {

    private static final String SECRET_KEY = "842ffdd30d2c48967c0c10dd1e81f832a3655adfe4eba60b4357b431e4fcbc5a";
    private final Set<String> blacklistedTokens = new HashSet<>();

    public void invalidateToken(String token) {
        blacklistedTokens.add(token);
    }

    public boolean isTokenInvalid(String token) {
        return blacklistedTokens.contains(token);
    }

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    public String getToken(Map<String, Object> extraClaims, UserDetails user) { 
        return Jwts.builder()
                .setClaims(extraClaims) // Agregar claims extra
                .setSubject(user.getUsername()) // Usuario
                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 1 día de expiración
                .signWith(getKey(), SignatureAlgorithm.HS256) // Firma con HS256
                .compact();
    }

    private Key getKey() {        
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token) {
      return getClaim(token, Claims::getSubject); 
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
      final String username = getUsernameFromToken(token);
      return (username.equals(userDetails.getUsername()) && !isTokenExpired(token)); 
    }

    private Claims getAllClaims(String token){
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody(); 
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date getExpiration (String token){
        return getClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date()); 
    }
}