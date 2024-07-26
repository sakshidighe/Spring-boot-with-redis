package com.sakshi.connect.spring.boot.with.redis.exception;

public class InternNotFoundException extends RuntimeException {
    public InternNotFoundException(String message) {
        super(message);
    }
}
