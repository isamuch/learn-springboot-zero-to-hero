package com.javaverse.course.springninja.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class CommonListeners<T extends CommonEntity> {

    @PrePersist
    private void prePersist(T e) {
        e.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate(T e) {
        e.setUpdatedDate(LocalDateTime.now());
    }
}
