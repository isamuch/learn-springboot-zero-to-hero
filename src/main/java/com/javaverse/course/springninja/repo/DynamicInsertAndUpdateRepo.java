package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.Example16DynamicInsertAndUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicInsertAndUpdateRepo extends JpaRepository<Example16DynamicInsertAndUpdate, Long> {
}
