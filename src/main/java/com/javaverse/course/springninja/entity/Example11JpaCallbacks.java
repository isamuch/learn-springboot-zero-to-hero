package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity(name="ex11_jpa_callbacks")
public class Example11JpaCallbacks {

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
        // จะทำงานก่อนที่ Entity Manager ทำการ Insert ลงใน Database
        setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate() {
        // จะทำงานก่อนที่ Entity Manager ทำการ Update ลงใน Database
        setUpdatedDate(LocalDateTime.now());
    }

    // Tips
    // วิธีการสร้าง Fields ใน Entity โดยจะไม่โดนนำไปสร้างเป็นคอลัมน์ใน Database
    @Transient
    private String excludedField;

    private transient String excludedField2;

    private static String excludedField3;
}
