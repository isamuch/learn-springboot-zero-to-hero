package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

}
