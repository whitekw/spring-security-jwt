package com.whitekw.springSecurityJwt.api.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserExceptionResult {

    NOT_EXISTS(HttpStatus.BAD_REQUEST, "U0001", "존재하지 않는 사용자입니다."),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "U0002", "이미 가입된 메일 주소입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
