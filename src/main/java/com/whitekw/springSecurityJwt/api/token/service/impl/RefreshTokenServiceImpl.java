package com.whitekw.springSecurityJwt.api.token.service.impl;

import com.whitekw.springSecurityJwt.api.token.dto.RefreshTokenResponseDto;
import com.whitekw.springSecurityJwt.api.token.exception.RefreshTokenException;
import com.whitekw.springSecurityJwt.api.token.exception.RefreshTokenExceptionResult;
import com.whitekw.springSecurityJwt.api.token.service.RefreshTokenService;
import com.whitekw.springSecurityJwt.api.token.vo.RefreshToken;
import com.whitekw.springSecurityJwt.config.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final JwtProvider jwtProvider;

    /**
     * refresh token을 이용하여 access token, refresh token 재발급
     * @param refreshToken refresh token
     * @return RefreshTokenResponseDto
     */
    @Override
    public RefreshTokenResponseDto refreshToken(String refreshToken) {
        checkRefreshToken(refreshToken);

        var id = RefreshToken.getRefreshToken(refreshToken);

        String newAccessToken = jwtProvider.generateAccessToken(id);

        RefreshToken.removeUserRefreshToken(id);

        String newRefreshToken = jwtProvider.generateRefreshToken(id);
        RefreshToken.putRefreshToken(newRefreshToken, id);

        return RefreshTokenResponseDto.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }

    /**
     * refresh token 검증
     * @param refreshToken refresh token
     */
    private void checkRefreshToken(String refreshToken) {
        if (Boolean.FALSE.equals(jwtProvider.validateToken(refreshToken))) {
            throw new RefreshTokenException(RefreshTokenExceptionResult.INVALID);
        }
    }
}
