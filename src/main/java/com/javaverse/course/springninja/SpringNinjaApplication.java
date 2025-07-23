package com.javaverse.course.springninja;

import com.javaverse.course.springninja.entity.EnumExample;
import com.javaverse.course.springninja.entity.JpaCallbacksExample;
import com.javaverse.course.springninja.entity.Product;
import com.javaverse.course.springninja.repo.EnumRepo;
import com.javaverse.course.springninja.repo.JpaCallbacksRepo;
import com.javaverse.course.springninja.repo.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringNinjaApplication implements CommandLineRunner {

    private final ProductRepo repo;
    private final JpaCallbacksRepo jpaCallbacksRepo;
    private final EnumRepo enumRepo;

    public SpringNinjaApplication(
            ProductRepo repo,
            JpaCallbacksRepo jpaCallbacksRepo,
            EnumRepo enumRepo
    ) {
        this.repo = repo;
        this.jpaCallbacksRepo = jpaCallbacksRepo;
        this.enumRepo = enumRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringNinjaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // stepNine();
        // stepEleven();
        stepTwelve();
    }

    // Example for Immutable Entity
    public void stepNine() {
        // INSERT
        log.info(() -> "BEGIN INSERT");
        Product p = new Product();
        p.setCode("C01");
        p.setName("INSERT");
        p = repo.save(p);
        log.info(() -> "AFTER INSERT : " + repo.findAll());

        // UPDATE BY JPA METHOD
        log.info(() -> "BEGIN UPDATE BY JPA METHOD");
        p.setName("JPA METHOD");
        repo.saveAndFlush(p);
        log.info(() -> "AFTER UPDATE BY JPA METHOD : " + repo.findAll());

        // UPDATE BY JPQL
        log.info(() -> "BEGIN UPDATE BY JPQL");
        try {
            repo.jpqlUpdate("JPQL", "C01");
            log.info(() -> "AFTER UPDATE BY JPQL : " + repo.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        // UPDATE BY SQL
        log.info(() -> "BEGIN UPDATE BY SQL");
        try {
            repo.sqlUpdate("SQL", "C01");
            log.info(() -> "AFTER UPDATE BY SQL : " + repo.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    // Example JPA Callbacks
    public void stepEleven() {
        JpaCallbacksExample p1 = new JpaCallbacksExample();
        p1.setName("AAA");
        p1.setCode("01");
        jpaCallbacksRepo.save(p1);

        JpaCallbacksExample p2 = new JpaCallbacksExample();
        p2.setName("BBB");
        p2.setCode("02");
        jpaCallbacksRepo.save(p2);

        p2.setName("BBB-1");
        jpaCallbacksRepo.save(p2);

        log.info(() -> jpaCallbacksRepo.findAll());
    }

    // Example Mapping Enums
    public void stepTwelve() {
        EnumExample p1 = new EnumExample();
        p1.setName("AAA");
        p1.setCode("01");
        p1.setStatus(EnumExample.Status.APPROVED);
        enumRepo.save(p1);

        EnumExample p2 = new EnumExample();
        p2.setName("BBB");
        p2.setCode("02");
        p2.setStatus(EnumExample.Status.NOT_APPROVED);
        enumRepo.save(p2);

        EnumExample p3 = new EnumExample();
        p3.setName("CCC");
        p3.setCode("03");
        p3.setStatus(EnumExample.Status.PENDING);
        enumRepo.save(p3);

        log.info(() -> enumRepo.findAll());
    }
}
