package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "products")
@SequenceGenerator(name="products_seq")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "products_seq")
    private Long id;
    private String code;
    private String name;

}
