package com.manager.domain.service;

import com.manager.domain.dto.UserDto;
import com.manager.domain.entity.User;
import com.manager.domain.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void save(@Valid UserDto userDto){
        User newUser = new User(userDto);
        String encodedPassword = passwordEncoder.encode(userDto.password());
        newUser.setPassword(encodedPassword);
        repository.save(newUser);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
