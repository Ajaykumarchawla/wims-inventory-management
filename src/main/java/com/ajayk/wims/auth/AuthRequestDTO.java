package com.ajayk.wims.auth;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String username;
    private String password;
    // getters and setters
}