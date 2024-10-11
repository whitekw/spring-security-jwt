package com.whitekw.springSecurityJwt.api.login.controller;

import com.whitekw.springSecurityJwt.api.login.dto.LoginRequestDto;
import com.whitekw.springSecurityJwt.api.login.dto.LoginResponseDto;
import com.whitekw.springSecurityJwt.api.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = loginService.login(loginRequestDto);
        return ResponseEntity.ok(loginResponseDto);
    }
}
