package com.whitekw.springSecurityJwt.api.user.service;

import com.whitekw.springSecurityJwt.api.user.dto.UserGetResponseDto;

public interface UserGetService {

    /**
     * 회원 idx로 회원 정보조회
     * @param id 회원 idx
     * @return UserGetResponseDto
     */
    UserGetResponseDto getUserById(long id);

    /**
     * 회원 email로 회원 정보 조회
     * @param email 회원 email
     * @return UserGetResponseDto
     */
    UserGetResponseDto getUserByEmail(String email);
}
