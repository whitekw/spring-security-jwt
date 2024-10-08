package com.whitekw.springSecurityJwt.config.exception.login;

import com.whitekw.springSecurityJwt.api.login.exception.LoginException;
import com.whitekw.springSecurityJwt.config.exception.common.ApiExceptionEntity;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LoginApiExceptionAdvice {

    @ExceptionHandler({LoginException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final LoginException e) {
        log.warn("[LoginApiExceptionAdvice] LoginException :: {}", e.getLoginExceptionResult().getMessage());

        return ResponseEntity
                .status(e.getLoginExceptionResult().getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(e.getLoginExceptionResult().getCode())
                        .errorMsg(e.getLoginExceptionResult().getMessage())
                        .build());
    }
}
