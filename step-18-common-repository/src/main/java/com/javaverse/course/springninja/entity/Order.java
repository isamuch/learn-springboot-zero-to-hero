package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "orders")
public class Order {

    @EmbeddedId
    @AttributeOverrides(value = {
            @AttributeOverride(name = "id", column = @Column(name = "od_id")),
            @AttributeOverride(name = "productId", column = @Column(name = "pd_id")),
    })
    private OrderId orderId;
    private int quantity;
}
