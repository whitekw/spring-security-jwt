package com.whitekw.springBootSecurityJwt.api.login.dto;

import lombok.Builder;

@Builder
public record LoginResponseDto(String accessToken, String refreshToken) {
}
