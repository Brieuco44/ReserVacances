package fr.reservacances.config;

import java.util.Date;

import javax.crypto.SecretKey;

import fr.reservacances.model.utilisateur.Utilisateur;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    private static final String KEY = "5G8bYzPZ3f29qRbTs7Uw0DA6HcX9kVLlMNvOEjqWpgdBtJRU1YsKFnmZr45QhX32";

    private JwtUtil() { }

    public static String generate(Utilisateur utilisateur) {
        SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes());
        Date now = new Date();

        return Jwts.builder()
            .subject(utilisateur.getUsername())
            .issuedAt(now)
            .expiration(new Date(now.getTime() + 36_000_000))
            .claim("user-id", utilisateur.getId())
            .signWith(key)
            .compact();
    }

    public static Jwt parse(String token) {
        if (token == null) {
            return Jwt.builder()
                .valid(false)
                .build()
            ;
        }
        
        try {
            SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes());
            
            Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
            
            return Jwt.builder()
                .valid(true)
                .username(claims.getSubject())
                .utilisateurId(claims.get("user-id", String.class))
                .build()
            ;
        }

        catch (Exception ex) {
            return Jwt.builder()
                .valid(false)
                .build()
            ;
        }
    }
}
