//package com.sba301.config;
//
//import com.sba301.dto.UserDetailDTO;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.function.Function;
//
//@Service
//public class JwtTokenProvider {
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//    @Value("${jwt.expiration}")
//    private long jwtExpiration;
//    private SecretKey key;
//
//    public long getJwtExpiration() {
//        return jwtExpiration;
//    }
//
//    @PostConstruct
//    private SecretKey init() {
//        if (key == null) {
//            key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
//        }
//        return key;
//    }
//    public String generateToken(UserDetailDTO principal) {
//        Date expiration = (new Date(System.currentTimeMillis() + jwtExpiration));
//        return Jwts.builder()
//                .subject(principal.getUsername())
//                .issuedAt(new Date())
//                .expiration(expiration)
//                .signWith(key)
//                .compact();
//    }
//    public String getUsernameFromToken(String token) {
//        return Jwts.parser()
//                .verifyWith(key)
//                .build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getSubject();
//    }
//    public boolean validateToken(String token, UserDetailDTO principal) {
//        try {
//            Jwts.parser()
//                    .verifyWith(key)
//                    .build()
//                    .parseSignedClaims(token);
//            String userName = extractClaim(token, key, Claims::getSubject);
//            //Check user
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//    public <T> T extractClaim(String token, SecretKey key, Function<Claims, T> claimsResolver) {
//        final Claims claims = Jwts.parser()
//                .verifyWith(key)
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//        return claimsResolver.apply(claims);
//    }
//}
