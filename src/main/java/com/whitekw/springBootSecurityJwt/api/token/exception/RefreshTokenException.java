package com.whitekw.springBootSecurityJwt.api.token.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefreshTokenException extends RuntimeException {

    private final RefreshTokenExceptionResult refreshTokenExceptionResult;
}
