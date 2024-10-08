package com.whitekw.springSecurityJwt.api.user.repository;


import com.whitekw.springSecurityJwt.api.user.dto.UserGetResponseDto;
import com.whitekw.springSecurityJwt.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    UserGetResponseDto findByUserId(long userId);

    Optional<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
