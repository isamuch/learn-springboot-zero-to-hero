package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "enum_example")
@Table(indexes = {
        @Index(name = "enum_example_idx_status", columnList = "status")
})
public class EnumExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String detail;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    private void prePersist() {
        setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate() {
        setUpdatedDate(LocalDateTime.now());
    }

    // @Enumerated(EnumType.ORDINAL) // จะทำการเรียงค่า 1, 2, 3 ตาม class enum **ไม่ควรใช้
    @Enumerated(EnumType.STRING)
    Status status;

    public enum Status {
        APPROVED,
        NOT_APPROVED,
        PENDING
    }
}
