package com.whitekw.springSecurityJwt.api.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserAddRequestDto {
    private String name;
    private String email;
    private String password;
}
