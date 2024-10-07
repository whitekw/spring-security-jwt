package com.whitekw.springBootSecurityJwt.api.login.service;

import com.whitekw.springBootSecurityJwt.api.login.dto.LoginRequestDto;
import com.whitekw.springBootSecurityJwt.api.login.dto.LoginResponseDto;

public interface LoginService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
