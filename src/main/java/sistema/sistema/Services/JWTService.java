package sistema.sistema.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

@Service
public class JWTService {

    private static final String SECRET_KEY = "842ffdd30d2c48967c0c10dd1e81f832a3655adfe4eba60b4357b431e4fcbc5a";

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
}
