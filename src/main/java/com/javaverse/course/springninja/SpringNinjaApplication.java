package com.javaverse.course.springninja;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringNinjaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNinjaApplication.class, args);
    }

}
