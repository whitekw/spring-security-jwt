package com.whitekw.springSecurityJwt.api.token.service;

import com.whitekw.springSecurityJwt.api.token.dto.RefreshTokenResponseDto;

public interface RefreshTokenService {

    RefreshTokenResponseDto refreshToken(String refreshToken);
}
