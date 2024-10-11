package com.whitekw.springSecurityJwt.api.login.controller;

import com.whitekw.springSecurityJwt.api.login.dto.LoginRequestDto;
import com.whitekw.springSecurityJwt.api.login.dto.LoginResponseDto;
import com.whitekw.springSecurityJwt.api.login.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    @Value("${jwt.refreshTokenExpire}")
    private long REFRESH_TOKEN_EXPIRE;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto, HttpServletResponse response) {
        LoginResponseDto loginResponseDto = loginService.login(loginRequestDto);

        ResponseCookie refreshTokenCookie = ResponseCookie.from("refreshToken", loginResponseDto.refreshToken())
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(REFRESH_TOKEN_EXPIRE)
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
                .body(loginResponseDto);
    }
}
