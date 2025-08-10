package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.Example15JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAttributeConverterRepo extends JpaRepository<Example15JpaAttributeConverter, Long> {
}
