package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name ="ex10_index")
@Table(indexes = {@Index(name = "ex10_index_index_code_and_name_unique", columnList = "code, name", unique = true)})
public class Example10Index {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String name;
}
