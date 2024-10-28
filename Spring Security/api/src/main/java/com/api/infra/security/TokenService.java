package com.api.infra.security;

import com.api.domain.entity.User;
import com.api.infra.exception.JwtTokenException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) throws JWTCreationException {
        var algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer("Manager")
                .withSubject(user.getEmail())
                // .withClaim("id", user.getId()) use to add info in token jwt
                .withExpiresAt(expireAt())
                .sign(algorithm);
    }

    public String getSubject(String token) throws SignatureVerificationException, JwtTokenException {
        return JWT.require(Algorithm.HMAC256("secret"))
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant expireAt() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}