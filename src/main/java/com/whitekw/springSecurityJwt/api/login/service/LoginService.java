package com.whitekw.springSecurityJwt.api.login.service;

import com.whitekw.springSecurityJwt.api.login.dto.LoginRequestDto;
import com.whitekw.springSecurityJwt.api.login.dto.LoginResponseDto;

public interface LoginService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
