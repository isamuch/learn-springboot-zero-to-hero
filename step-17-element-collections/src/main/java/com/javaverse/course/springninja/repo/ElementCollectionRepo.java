package com.javaverse.course.springninja.repo;

import com.javaverse.course.springninja.entity.Example17ElementCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementCollectionRepo extends JpaRepository<Example17ElementCollection, Long> {
}
