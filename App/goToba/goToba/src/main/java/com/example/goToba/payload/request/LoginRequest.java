package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
