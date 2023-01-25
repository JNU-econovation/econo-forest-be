package com.example.econoforestbe.domain.person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person,String> {
}
