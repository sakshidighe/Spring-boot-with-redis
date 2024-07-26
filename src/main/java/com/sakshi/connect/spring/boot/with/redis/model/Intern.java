package com.sakshi.connect.spring.boot.with.redis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
    @RedisHash("Intern")
    @Getter
    @Setter
    @AllArgsConstructor
    public class Intern implements Serializable {

        public Intern() {

        }

        public enum Gender {
            MALE, FEMALE
        }

        private String id;
        private String name;
        private Gender gender;

    }


