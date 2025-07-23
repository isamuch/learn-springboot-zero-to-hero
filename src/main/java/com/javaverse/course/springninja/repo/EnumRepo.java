package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.EnumExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnumRepo extends JpaRepository<EnumExample, Long> {
}
