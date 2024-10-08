package com.whitekw.springSecurityJwt.api.user.service;

import com.whitekw.springSecurityJwt.api.user.dto.UserAddRequestDto;

public interface UserService {
    void addUser(UserAddRequestDto reqDto);
}
