package com.javaverse.course.springninja.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(value = CommonListeners.class)
public abstract class CommonEntity {

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Version
    private int version;
}
