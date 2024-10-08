package com.whitekw.springSecurityJwt.api.user.dto;

import com.whitekw.springSecurityJwt.api.user.entity.User;
import lombok.Builder;

@Builder
public record UserGetResponseDto(long userId, String email, String password, String name) {

    public static UserGetResponseDto of(User user) {
        return UserGetResponseDto.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }
}
