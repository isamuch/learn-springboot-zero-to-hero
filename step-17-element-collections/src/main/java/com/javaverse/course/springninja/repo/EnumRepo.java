package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.Example12Enum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnumRepo extends JpaRepository<Example12Enum, Long> {
}
