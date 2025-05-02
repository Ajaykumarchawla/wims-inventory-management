package com.ajayk.wims.auth;

import lombok.Getter;

@Getter
public class AuthResponseDTO {
    private String token;
    public AuthResponseDTO(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
