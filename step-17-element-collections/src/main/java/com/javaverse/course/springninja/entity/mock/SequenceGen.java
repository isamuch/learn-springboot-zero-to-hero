package com.javaverse.course.springninja.entity.mock;

import jakarta.persistence.*;
import lombok.Data;

@Data
//@Entity
@SequenceGenerator(name = "my_seq")
public class SequenceGen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Long id;

    private String code;
}
