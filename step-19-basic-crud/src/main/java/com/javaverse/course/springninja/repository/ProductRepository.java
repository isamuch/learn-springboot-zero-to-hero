package com.javaverse.course.springninja.repository;

import com.javaverse.course.springninja.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CommonRepository<Product, Long> {
}
