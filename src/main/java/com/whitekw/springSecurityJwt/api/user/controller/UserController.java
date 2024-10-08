package com.whitekw.springSecurityJwt.api.user.controller;

import com.whitekw.springSecurityJwt.api.user.service.UserGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserGetService userService;


}
