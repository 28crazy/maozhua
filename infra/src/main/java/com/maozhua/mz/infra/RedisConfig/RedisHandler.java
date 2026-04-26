package com.maozhua.mz.infra.RedisConfig;

import java.time.Duration;
import java.util.Collections;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

@Component
public class RedisHandler {

    private static final String LOCK_KEY_PREFIX = "lock:";
    private static final Long RELEASE_LOCK_SUCCESS = 1L;

    private static final DefaultRedisScript<Long> UNLOCK_SCRIPT = new DefaultRedisScript<>(
            "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                    "return redis.call('del', KEYS[1]) " +
                    "else return 0 end",
            Long.class);

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisHandler(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public String tryLock(String lockKey, long expireSeconds) {
        String lockValue = UUID.randomUUID().toString();
        Boolean lockResult = stringRedisTemplate.opsForValue().setIfAbsent(
                buildLockKey(lockKey),
                lockValue,
                Duration.ofSeconds(expireSeconds));
        return Boolean.TRUE.equals(lockResult) ? lockValue : null;
    }

    public boolean unlock(String lockKey, String lockValue) {
        Long releaseResult = stringRedisTemplate.execute(
                UNLOCK_SCRIPT,
                Collections.singletonList(buildLockKey(lockKey)),
                lockValue);
        return RELEASE_LOCK_SUCCESS.equals(releaseResult);
    }

    private String buildLockKey(String lockKey) {
        return LOCK_KEY_PREFIX + lockKey;
    }
}
