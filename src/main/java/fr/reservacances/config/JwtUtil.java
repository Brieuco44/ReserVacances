package fr.reservacances.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    private static final String KEY = "5G8bYzPZ3f29qRbTs7Uw0DA6HcX9kVLlMNvOEjqWpgdBtJRU1YsKFnmZr45QhX32";

    private JwtUtil() { }

    public static String generate(String username, String id) {
        // Création de la clé de signature
        SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes());
        Date now = new Date();

        return Jwts.builder()
            .subject(username)
            .issuedAt(now)
            .expiration(new Date(now.getTime() + 36_000_000))
            .claim("identifiant", id)
            .signWith(key)
            .compact();
    }

    public static boolean isValid(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes());
            
            Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
            
            System.out.println(claims.get("info1", String.class));

            return true;
        }

        catch (Exception ex) {
            return false;
        }
    }

    public static String getIdentifiant(String token) {
        SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes());

        Claims claims = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();

        return claims.get("identifiant", String.class);
    }
}
