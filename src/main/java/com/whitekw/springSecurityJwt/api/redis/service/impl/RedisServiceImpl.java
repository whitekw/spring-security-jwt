package com.whitekw.springSecurityJwt.api.redis.service.impl;

import com.whitekw.springSecurityJwt.api.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate redisTemplate;

    @Override
    public void setValue(String key, String value) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    @Override
    public void setValue(String key, String value, Duration duration) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, duration);
    }

    @Override
    public String getValue(String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        if (valueOperations.get(key) == null) return "";
        return String.valueOf(valueOperations.get(key));
    }

    @Override
    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }
}
