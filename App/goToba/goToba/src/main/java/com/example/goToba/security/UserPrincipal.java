package com.example.goToba.security;

import com.example.goToba.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Sogumontar Hendra Simangunsong on 03/04/2020.
 */
//implements userdDetails
public class UserPrincipal  {
//    private String sku;
//
//    private String nickName;
//
//    private String username;
//
//    @JsonIgnore
//    private String email;
//
//    @JsonIgnore
//    private String password;
//
//    private int status;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrincipal(String sku, String nickName, String username, String email, String password ,int status, Collection<? extends GrantedAuthority> authorities) {
//        this.sku = sku;
//        this.nickName = nickName;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.status=status;
//        this.authorities = authorities;
//    }
//
//    public static UserPrincipal create(Users user) {
////        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
////                new SimpleGrantedAuthority(role.getName().name())
////        ).collect(Collectors.toList());
//
//        return new UserPrincipal(
//                user.getSku(),
//                user.getNickname(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getStatus(),
//                authorities
//        );
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getSku() {
//        return sku;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserPrincipal that = (UserPrincipal) o;
//        return Objects.equals(sku, that.sku);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(sku);
//    }
}