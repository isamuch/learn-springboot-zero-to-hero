package com.javaverse.course.springninja.repository;

import com.javaverse.course.springninja.entity.Order;
import com.javaverse.course.springninja.entity.OrderId;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CommonRepository<Order, OrderId> {
}
