package com.whitekw.springBootSecurityJwt.api.token.dto;

import lombok.Builder;

@Builder
public record RefreshTokenResponseDto(String accessToken, String refreshToken) {
}
