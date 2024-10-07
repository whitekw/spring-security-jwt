package com.whitekw.springBootSecurityJwt.api.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequestDto {
    private String name;
    private String email;
    private String password;
}
