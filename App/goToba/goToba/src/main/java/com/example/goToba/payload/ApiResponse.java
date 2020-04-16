package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/03/2020.
 */

public class ApiResponse {
    Boolean success;
    String message;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
