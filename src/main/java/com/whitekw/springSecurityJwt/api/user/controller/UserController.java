package com.whitekw.springSecurityJwt.api.user.controller;

import com.whitekw.springSecurityJwt.api.user.dto.UserAddRequestDto;
import com.whitekw.springSecurityJwt.api.user.service.UserGetService;
import com.whitekw.springSecurityJwt.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final UserGetService userGetService;

    @GetMapping("/user")
    public ResponseEntity<String> getUser() {
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> addUser(@RequestBody UserAddRequestDto dto) {
        userService.addUser(dto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser() {
        return null;
    }
}
