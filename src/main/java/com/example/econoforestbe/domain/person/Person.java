package com.example.econoforestbe.domain;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@RedisHash(value = "person",timeToLive = 60)
public class Person {
    @Id
    privat
}
