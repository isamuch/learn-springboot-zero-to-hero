package com.javaverse.course.springninja.entity;

import com.javaverse.course.springninja.entity.converter.Example15StatusConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Data
@Entity(name="ex15_jpa_attribute_converter")
public class Example15JpaAttributeConverter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String detail;

    //@Convert(converter= Example15StatusConverter.class)
    @Column(length = 1)
    Status status;

    @RequiredArgsConstructor
    public enum Status {
        APPROVED("A"),
        NOT_APPROVED("N"),
        PENDING("P");

        @Getter
        private final String code;

        public static Example15JpaAttributeConverter.Status codeToStatus(String code) {
            return Stream.of(Example15JpaAttributeConverter.Status.values()).parallel()
                    .filter(status -> status.getCode().equalsIgnoreCase(code))
                    .findAny().orElseThrow(() -> new IllegalArgumentException("The code : " + code + " is illegal argument."));
        }
    }
}
