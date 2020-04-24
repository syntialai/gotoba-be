package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import java.util.Collection;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@NoArgsConstructor
@Data
public class Users  implements UserDetails {

    public String sku;

    public String  nickname;

    public String username;

    @Email
    public String email;

    public String password;

    private RoleName roles ;

    private String test;
    public int status;

    public Users(String sku, String nickname, String username, @Email String email, String password, RoleName roles, int status) {
        this.sku = sku;
        this.nickname = nickname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public RoleName getRoles() {
        return roles;
    }

    public void setRoles(RoleName roles) {
        this.roles = roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
