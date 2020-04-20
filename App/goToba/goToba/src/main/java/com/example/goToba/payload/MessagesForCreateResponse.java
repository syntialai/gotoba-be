package com.example.goToba.payload;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 17/04/2020.
 */
@NoArgsConstructor
@Data
public class MessagesForCreateResponse {
    String code;
    String status;
    String data;

    public MessagesForCreateResponse(String code, String status, String data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }
}
