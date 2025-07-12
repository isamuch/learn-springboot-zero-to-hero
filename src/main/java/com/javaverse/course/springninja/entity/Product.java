package com.javaverse.course.springninja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Product {

    @Id
    private Long id;
    private String code;
    private String name;

}
