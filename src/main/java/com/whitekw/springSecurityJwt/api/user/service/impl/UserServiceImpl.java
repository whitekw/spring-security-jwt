package com.whitekw.springSecurityJwt.api.user.service.impl;

import com.whitekw.springSecurityJwt.api.user.dto.UserAddRequestDto;
import com.whitekw.springSecurityJwt.api.user.entity.User;
import com.whitekw.springSecurityJwt.api.user.repository.UserRepository;
import com.whitekw.springSecurityJwt.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(UserAddRequestDto reqDto) {

        User user = User.of(reqDto);
        user.encryptPassword(bCryptPasswordEncoder);
        userRepository.save(user);
    }
}
