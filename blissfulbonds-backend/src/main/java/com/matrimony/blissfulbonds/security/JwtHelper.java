package com.matrimony.blissfulbonds.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtHelper {
    private static String JWT_SECRET;
    private static long JWT_EXPIRATION_MINUTES;
    public JwtHelper(@Value("${app.jwt.secret}") final String jwtSecret,
                     @Value("${app.jwt.expiration.minutes}") long jwtExpirationMinutes) {
        this.JWT_SECRET = jwtSecret;
        this.JWT_EXPIRATION_MINUTES = jwtExpirationMinutes;
    }


    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET));
    }
    public static String generateToken(String userName) {
        var now = Instant.now();
        return Jwts.builder()
                .subject(userName)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(JWT_EXPIRATION_MINUTES, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }

    public static String extractUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    public static Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private static Claims getTokenBody(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(JWT_SECRET)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (SignatureException | ExpiredJwtException e) { // Invalid signature or expired token
            throw new AccessDeniedException("Access denied: " + e.getMessage());
        }
    }

    private static boolean isTokenExpired(String token) {
        Claims claims = getTokenBody(token);
        return claims.getExpiration().before(new Date());
    }
}
