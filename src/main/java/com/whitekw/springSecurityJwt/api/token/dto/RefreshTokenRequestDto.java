package com.whitekw.springSecurityJwt.api.token.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RefreshTokenRequestDto {

    @NotNull
    @NotEmpty
    private String refreshToken;
}
