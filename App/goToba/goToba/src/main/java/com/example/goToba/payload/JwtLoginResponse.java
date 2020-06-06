package com.example.goToba.payload;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
@NoArgsConstructor
@Data
public class JwtLoginResponse {
    private String token;
//    private String tokenType = "Bearer";
    private String role;
    private String sku_user;
//    private Integer status;
    private String name;
//    private String email;

    public JwtLoginResponse(String nickName, String role, String sku_user, String token) {
        this.name = nickName;
        this.role = role;
        this.sku_user = sku_user;
        this.token = token;
    }

    public JwtLoginResponse(String accessToken , String role) {
        this.token = accessToken;
        this.role = role;
    }


}
