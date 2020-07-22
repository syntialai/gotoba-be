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
@AllArgsConstructor
public class Users  implements UserDetails {

    public String sku;

    public String  nickname;

    public String username;

    @Email
    public String email;

    public String password;

    private RoleName roles ;

    public String image;

    public String status;


    public RoleName getRoles() {
        return roles;
    }

    public void setRoles(RoleName roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
