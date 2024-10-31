package com.manager.controller;

import com.manager.domain.dto.DataTokenJWTDTO;
import com.manager.domain.dto.LoginDto;
import com.manager.domain.dto.UserReturnDto;
import com.manager.domain.entity.User;
import com.manager.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController extends BaseController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginData){
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.password());
        var authentication = manager.authenticate(authenticationToken);
        User currentUser = (User) authentication.getPrincipal();
        var tokenJWT = tokenService.generateToken(currentUser);
        UserReturnDto returnUser = new UserReturnDto(currentUser.getEmail(), currentUser.getFirstName(), currentUser.getLastName());
        return ResponseEntity.ok(new DataTokenJWTDTO(tokenJWT, returnUser));
    }
}
