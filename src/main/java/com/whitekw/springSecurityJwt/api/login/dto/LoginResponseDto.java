package com.whitekw.springSecurityJwt.api.login.dto;

import lombok.Builder;

@Builder
public record LoginResponseDto(String accessToken, String refreshToken) {
}
