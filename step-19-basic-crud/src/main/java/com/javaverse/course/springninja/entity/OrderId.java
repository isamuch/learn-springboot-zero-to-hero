package com.javaverse.course.springninja.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable // for EmbeddedId only
public class OrderId implements Serializable {

    private long id;
    private long productId;
}
