package com.sba301.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO implements UserDetails {
    private int userId;
    private  String username;
    private String password;
    private String email;
    private int roleId;
    private String role;
    public UserDTO(String username, String password, String email, int roleId, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
        this.role = role;
    }

    public UserDTO(int userId, String username, String password, String email, int roleId, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}

