package com.javaverse.course.springninja;

import com.javaverse.course.springninja.entity.Example13DryEntity;
import com.javaverse.course.springninja.entity.Example12Enum;
import com.javaverse.course.springninja.entity.Example11JpaCallbacks;
import com.javaverse.course.springninja.entity.Product;
import com.javaverse.course.springninja.repo.DryEntityRepo;
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
    private final DryEntityRepo dryEntityRepo;

    public SpringNinjaApplication(
            ProductRepo repo,
            JpaCallbacksRepo jpaCallbacksRepo,
            EnumRepo enumRepo,
            DryEntityRepo dryEntityRepo
    ) {
        this.repo = repo;
        this.jpaCallbacksRepo = jpaCallbacksRepo;
        this.enumRepo = enumRepo;
        this.dryEntityRepo = dryEntityRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringNinjaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // stepNine();
        // stepEleven();
        // stepTwelve();
        stepThirteen();
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
        Example11JpaCallbacks p1 = new Example11JpaCallbacks();
        p1.setName("AAA");
        p1.setCode("01");
        jpaCallbacksRepo.save(p1);

        Example11JpaCallbacks p2 = new Example11JpaCallbacks();
        p2.setName("BBB");
        p2.setCode("02");
        jpaCallbacksRepo.save(p2);

        p2.setName("BBB-1");
        jpaCallbacksRepo.save(p2);

        log.info(() -> jpaCallbacksRepo.findAll());
    }

    // Example Mapping Enums
    public void stepTwelve() {
        Example12Enum p1 = new Example12Enum();
        p1.setName("AAA");
        p1.setCode("01");
        p1.setStatus(Example12Enum.Status.APPROVED);
        enumRepo.save(p1);

        Example12Enum p2 = new Example12Enum();
        p2.setName("BBB");
        p2.setCode("02");
        p2.setStatus(Example12Enum.Status.NOT_APPROVED);
        enumRepo.save(p2);

        Example12Enum p3 = new Example12Enum();
        p3.setName("CCC");
        p3.setCode("03");
        p3.setStatus(Example12Enum.Status.PENDING);
        enumRepo.save(p3);

        log.info(() -> enumRepo.findAll());
    }

    public void stepThirteen() {
        Example13DryEntity p1 = new Example13DryEntity();
        p1.setName("AAA");
        p1.setCode("01");
        dryEntityRepo.save(p1);

        p1.setDetail("abcd");
        dryEntityRepo.save(p1);
    }
}
