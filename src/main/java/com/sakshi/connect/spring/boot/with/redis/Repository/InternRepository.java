package com.sakshi.connect.spring.boot.with.redis.Repository;

import com.sakshi.connect.spring.boot.with.redis.model.Intern;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends CrudRepository<Intern, String> {

}

