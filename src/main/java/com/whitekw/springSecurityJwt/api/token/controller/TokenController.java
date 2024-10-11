package com.whitekw.springSecurityJwt.api.token.controller;

import com.whitekw.springSecurityJwt.api.token.dto.RefreshTokenRequestDto;
import com.whitekw.springSecurityJwt.api.token.dto.RefreshTokenResponseDto;
import com.whitekw.springSecurityJwt.api.token.service.RefreshTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TokenController {

    private final RefreshTokenService refreshTokenService;

    @Value("${jwt.refreshTokenExpire}")
    private long REFRESH_TOKEN_EXPIRE;

    @PostMapping("token-refresh")
    public ResponseEntity<RefreshTokenResponseDto> tokenRefresh(@CookieValue String refreshToken) {
        RefreshTokenResponseDto refreshTokenResponseDto = refreshTokenService.refreshToken(refreshToken);

        ResponseCookie refreshTokenCookie = ResponseCookie.from("refreshToken", refreshTokenResponseDto.refreshToken())
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(REFRESH_TOKEN_EXPIRE)
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                .body(refreshTokenResponseDto);
    }


}
