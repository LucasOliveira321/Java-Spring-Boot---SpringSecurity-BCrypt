package com.manager.domain.entity;

import com.manager.domain.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity(name="Users")
@Table(name="users")
@NoArgsConstructor
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    @Column(name = "created_on")
    private LocalDate createdOn;
    @Column(name = "updated_on")
    private LocalDate updatedOn;

    public User(@Valid UserDto userDto){
        this.firstName = userDto.firstName();
        this.lastName = userDto.lastName();
        this.email = userDto.email();
        this.password = userDto.password();
        this.createdOn = LocalDate.now();
        this.updatedOn = LocalDate.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        StringBuilder name = new StringBuilder(this.firstName);
        name.append(" ");
        name.append(this.lastName);
        return name.toString();
    }
}
