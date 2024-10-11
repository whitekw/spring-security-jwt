package com.whitekw.springSecurityJwt.config.security;

import com.google.gson.JsonObject;
import com.whitekw.springSecurityJwt.config.exception.common.ApiExceptionResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class CustomAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        log.info("[CustomAuthenticationEntryPointHandler] :: {}", authException.getMessage());
        log.info("[CustomAuthenticationEntryPointHandler] :: {}", request.getRequestURL());
        log.info("[CustomAuthenticationEntryPointHandler] :: 토근 정보가 만료되었거나 존재하지 않음");

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setStatus(ApiExceptionResult.ACCESS_DENIED.getStatus().value());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With");

        JsonObject returnJson = new JsonObject();
        returnJson.addProperty("errorCode", ApiExceptionResult.ACCESS_DENIED.getCode());
        returnJson.addProperty("errorMsg", ApiExceptionResult.ACCESS_DENIED.getMessage());

        PrintWriter writer = response.getWriter();
        writer.print(returnJson);
        writer.flush();
    }
}
