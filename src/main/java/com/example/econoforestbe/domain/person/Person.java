package com.example.econoforestbe.domain.person;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@RedisHash(value = "person",timeToLive = 60)
public class Person {
    @Id
    private Long id;
    private String name;
    private Long year;

}
