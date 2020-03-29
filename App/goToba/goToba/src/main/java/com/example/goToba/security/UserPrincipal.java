package com.example.goToba.security;

import com.example.goToba.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
@Data
@NoArgsConstructor
public class UserPrincipal implements UserDetails {
    private String sku;

    private String nickName;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private int status;

    public UserPrincipal(String sku, String nickName, String username, String email, String password, int status) {
        this.sku = sku;
        this.nickName = nickName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public static UserPrincipal create(Users user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
//                new SimpleGrantedAuthority(role.getName().name())
//        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getSku(),
                user.getNickname(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus()
        );
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
