package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE products p SET p.name = :name WHERE p.code = :code")
    int jpqlUpdate(@Param("name") String name, @Param("code") String code);

    @Transactional
    @Modifying
    @Query(value = "UPDATE PRODUCTS p SET p.NAME = :name WHERE p.CODE = :code", nativeQuery = true)
    int sqlUpdate(@Param("name") String name, @Param("code") String code);

}
