package com.ajayk.wims.auth;

import com.ajayk.wims.user.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SignupRequestDTO {
    private String username;
    private String password;
    private Role role;
}
