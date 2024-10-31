package com.manager.infra.exception;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JwtTokenException.class)
    public ResponseEntity<Object> handleJwtTokenException(JwtTokenException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SignatureVerificationException.class)
    public ResponseEntity<Object> handleSignatureVerificationException(SignatureVerificationException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("message", "Invalid token signature.");

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<Object> handleServletException(ServletException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        body.put("status", HttpStatus.FAILED_DEPENDENCY.value());
        body.put("message", "ServletException.");

        return new ResponseEntity<>(body, HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleServletException(IOException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        body.put("status", HttpStatus.FAILED_DEPENDENCY.value());
        body.put("message", "IOException.");

        return new ResponseEntity<>(body, HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler(JWTDecodeException.class)
    public ResponseEntity<Object> handleJWTDecodeException(JWTDecodeException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
