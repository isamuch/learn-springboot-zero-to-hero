package com.javaverse.course.springninja.entity.mock;

import jakarta.persistence.*;
import lombok.Data;

@Data
//@Entity
@TableGenerator(name = "my_table")
public class TableGen {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "my_table")
    private Long id;

    private String code;
}
