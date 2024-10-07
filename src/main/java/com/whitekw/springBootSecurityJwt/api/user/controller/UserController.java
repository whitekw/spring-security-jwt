package com.whitekw.springBootSecurityJwt.api.user.controller;

import com.whitekw.springBootSecurityJwt.api.user.service.UserGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserGetService userService;


}
