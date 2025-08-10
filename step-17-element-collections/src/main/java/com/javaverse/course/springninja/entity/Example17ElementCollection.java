package com.javaverse.course.springninja.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "ex17_element_collection")
public class Example17ElementCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;

    @ElementCollection
    @Column(name = "alias_name", length = 20)
    @CollectionTable(name = "ex17_alias_name_custom", joinColumns = @JoinColumn(name = "ex17_id_custom"))
    private Set<String> aliasNames = new HashSet<>();

}
