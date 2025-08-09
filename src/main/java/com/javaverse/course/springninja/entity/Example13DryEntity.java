package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name="ex13_dry_entity")
// @ExcludeDefaultListeners กรณ๊ที่ต้องการ fields แต่ไม่อยากได้ Listeners
public class Example13DryEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String detail;
}
