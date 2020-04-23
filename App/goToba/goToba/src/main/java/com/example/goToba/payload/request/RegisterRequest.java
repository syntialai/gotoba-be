package com.example.goToba.payload.request;


import com.example.goToba.model.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nickname;
    private String username;
    @Email
    private String email;
    private String password;
    private String confirmPassword;
    private RoleName role;

}
