package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.Example11JpaCallbacks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCallbacksRepo extends JpaRepository<Example11JpaCallbacks, Long> {
}
