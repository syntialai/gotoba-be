package com.example.goToba.model;

import com.example.goToba.model.constants.TablesConstant;
import com.example.goToba.model.timestamp.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/03/2020.
 */

@NoArgsConstructor
@Entity
//@Table(name = TablesConstant.TABEL_USER, uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "username"
//        }),
//        @UniqueConstraint(columnNames = {
//                "email"
//        })
//})
@Table(name = TablesConstant.TABEL_USER)
public class Users extends Timestamp {
    @Id
    public String sku;

    @Column(name = "nickname")
    public String  nickname;

    @Column(name = "username")
    public String username;

    @Email
    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "sku_user"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    @Column(name = "status")
    public int status;

    public Users(String sku, String nickname, String username, @Email String email, String password, int status) {
        this.sku = sku;
        this.nickname = nickname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
