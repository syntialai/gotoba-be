package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/07/2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String nickname;
    private String username;
    @Email
    private String email;
    private String image;

}
