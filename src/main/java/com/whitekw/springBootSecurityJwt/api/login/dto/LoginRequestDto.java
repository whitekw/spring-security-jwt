package com.whitekw.springBootSecurityJwt.api.login.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginRequestDto {

    private String email;
    private String password;
}
