package com.whitekw.springBootSecurityJwt.api.token.service;

import com.whitekw.springBootSecurityJwt.api.token.dto.RefreshTokenResponseDto;

public interface RefreshTokenService {

    RefreshTokenResponseDto refreshToken(String refreshToken);
}
