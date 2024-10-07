package com.whitekw.springBootSecurityJwt.api.user.service.impl;

import com.whitekw.springBootSecurityJwt.api.user.dto.UserGetResponseDto;
import com.whitekw.springBootSecurityJwt.api.user.exception.UserException;
import com.whitekw.springBootSecurityJwt.api.user.exception.UserExceptionResult;
import com.whitekw.springBootSecurityJwt.api.user.repository.UserRepository;
import com.whitekw.springBootSecurityJwt.api.user.service.UserGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGetServiceImpl implements UserGetService {

    private final UserRepository userRepository;

    @Override
    public UserGetResponseDto getUserById(long id) {
        return userRepository.findById(id)
                .map(UserGetResponseDto::of)
                .orElseThrow(() -> new UserException(UserExceptionResult.NOT_EXISTS));
    }

    @Override
    public UserGetResponseDto getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserGetResponseDto::of)
                .orElseThrow(() -> new UserException(UserExceptionResult.NOT_EXISTS));
    }
}
