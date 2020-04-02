package com.example.goToba.payload.request;

import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */


@NoArgsConstructor
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
