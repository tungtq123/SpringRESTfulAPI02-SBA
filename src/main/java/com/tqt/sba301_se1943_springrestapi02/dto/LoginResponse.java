package com.sba301.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private long expireIn;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", expireIn=" + expireIn +
                '}';
    }
}
