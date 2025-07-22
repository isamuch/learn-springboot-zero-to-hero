package com.javaverse.course.springninja.entity;

/*
Composite class rules
    - public class
    - public no-arg constructor
    - Implement Serializable
    - Override equals , hasCode
    - Can be use @EmbeddedId / @IdClass
*/

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable // for EmbeddedId only
public class OrderId implements Serializable {

    private long id;
    private long productId;
}
