package com.whitekw.springSecurityJwt.api.redis.service;

import java.time.Duration;

public interface RedisService {

    void setValue(String key, String value);

    void setValue(String key, String value, Duration duration);

    String getValue(String key);

    void deleteValue(String key);
}
