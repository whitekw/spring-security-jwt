package com.whitekw.springSecurityJwt.api.token.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAccessTokenResponseDto {
    private String accessToken;
}
