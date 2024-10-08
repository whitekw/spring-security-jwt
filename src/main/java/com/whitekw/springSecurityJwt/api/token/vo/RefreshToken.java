package com.whitekw.springSecurityJwt.api.token.vo;

import com.whitekw.springSecurityJwt.api.token.exception.RefreshTokenException;
import com.whitekw.springSecurityJwt.api.token.exception.RefreshTokenExceptionResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RefreshToken {

    protected static final Map<String, Long> refreshTokens = new HashMap<>();

    public static Long getRefreshToken(String refreshToken) {
        return Optional.ofNullable(refreshTokens.get(refreshToken))
                .orElseThrow(() -> new RefreshTokenException(RefreshTokenExceptionResult.NOT_EXIST));
    }

    public static void putRefreshToken(String refreshToken, long id) {
        refreshTokens.put(refreshToken, id);
    }

    private static void removeRefreshToken(String refreshToken) {
        refreshTokens.remove(refreshToken);
    }

    public static void removeUserRefreshToken(long refreshToken) {
        for (Map.Entry<String, Long> entry : refreshTokens.entrySet()) {
            if (entry.getValue() == refreshToken) {
                removeRefreshToken(entry.getKey());
            }
        }
    }
}
