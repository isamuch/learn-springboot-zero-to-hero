package com.javaverse.course.springninja.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

@Data
@Entity(name="ex14_mapping_lob")
public class Example14MappingLOB extends CommonEntity {

    @EmbeddedId
    private OrderId orderId;
    private int quantity;

    @Lob
    private String details; // CLOB

    @Lob
    @Nationalized
    private String nationalDetails; // NCLOB

    @Lob
    private byte[] photos; //BLOB
}
