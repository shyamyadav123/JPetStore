package org.csu.my_pet_store_spring;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.csu.my_pet_store_spring.persistence")
public class MyPetStoreSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPetStoreSpringApplication.class, args);
    }

}
