package com.javaverse.course.springninja;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringNinjaApplication {

    public static String expensiveMethod(String level) {
        System.out.println("Perform Expensive Method : " + level);
        return level;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringNinjaApplication.class, args);
        log.info("Hello: {}", "samuch");

        log.trace("{} Message", () -> expensiveMethod("TRACE"));
        log.debug("{} Message", () -> expensiveMethod("DEBUG"));
        log.info("{} Message", () -> expensiveMethod("INFO"));
        log.warn("{} Message", () -> expensiveMethod("WARN"));
        log.error("{} Message", () -> expensiveMethod("TRACE"));
        log.fatal("{} Message", () -> expensiveMethod("FATAL"));
    }

}
