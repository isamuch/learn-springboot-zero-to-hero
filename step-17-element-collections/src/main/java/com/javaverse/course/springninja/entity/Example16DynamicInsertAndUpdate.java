package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Nationalized;

@Data
@Entity(name = "ex16_dynamic_insert_and_update")
@DynamicInsert
@DynamicUpdate
public class Example16DynamicInsertAndUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;

    @Lob
    private String details; // CLOB

    @Lob
    @Nationalized
    private String nationalDetails; // NCLOB

    @Lob
    private byte[] photos; //BLOB
}
