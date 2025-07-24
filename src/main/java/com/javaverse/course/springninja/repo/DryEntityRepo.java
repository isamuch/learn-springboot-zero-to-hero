package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.DryEntityExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DryEntityRepo extends JpaRepository<DryEntityExample, Long> {
}
