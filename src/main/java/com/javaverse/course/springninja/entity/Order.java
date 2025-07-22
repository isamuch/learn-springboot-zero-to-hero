package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "orders")
//@IdClass(OrderId.class)
public class Order {

//    // IdClass
//
//    @Id
//    @Column(name = "o_id")
//    private long id;
//
//    @Id
//    @Column(name = "p_id")
//    private long productId;

    @EmbeddedId
    @AttributeOverrides(value = {
            @AttributeOverride(name = "id", column = @Column(name = "od_id")),
            @AttributeOverride(name = "productId", column = @Column(name = "pd_id")),
    })
    private OrderId orderId;

    private int quantity;
}
