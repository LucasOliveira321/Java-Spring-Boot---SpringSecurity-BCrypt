package com.manager.controller;

import com.manager.domain.dto.UserDto;
import com.manager.domain.entity.User;
import com.manager.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    private final String url = "/users";

    @GetMapping(url)
    public  ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(url)
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto userDto){
        userService.save(userDto);
        return ResponseEntity.ok(userDto);
    }
}
