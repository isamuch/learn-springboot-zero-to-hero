package com.javaverse.course.springninja;

import com.javaverse.course.springninja.entity.Product;
import com.javaverse.course.springninja.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SpringNinjaApplication implements CommandLineRunner {

    private final ProductRepository productRepo;

    public SpringNinjaApplication(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringNinjaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("COUNT: {}", productRepo.count());

        // CREATE
        Product product = new Product();
        product.setName("COFFEE");
        product.setCode("P001");
        productRepo.save(product);
        log.info("C [CREATED]: {}", product);
        log.info("COUNT: {}", productRepo.count());

        // READ
        product = productRepo.findById(1L).orElseThrow(() -> new RuntimeException("Product not found"));
        log.info("R [READ]: {}", product);

        // UPDATE
        product.setName("TEA");
        productRepo.save(product);
        log.info("U [UPDATE]: {}", product);

        // DELETE
        productRepo.delete(product);
        log.info("D [DELETE]: {}", productRepo.findAll());
        log.info("COUNT: {}", productRepo.count());
    }
}
