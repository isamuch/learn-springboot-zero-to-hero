package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name ="tb_ex_index")
@Table(indexes = {@Index(name = "tb_ex_index_code_and_name_unique", columnList = "code, name", unique = true)})
public class IndexExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String name;
}
