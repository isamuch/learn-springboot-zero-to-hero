package com.javaverse.course.springninja.entity.converter;

import com.javaverse.course.springninja.entity.Example15JpaAttributeConverter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class Example15StatusConverter implements AttributeConverter<Example15JpaAttributeConverter.Status, String> {

    @Override
    public String convertToDatabaseColumn(Example15JpaAttributeConverter.Status status) {
        return Objects.isNull(status) ? null : status.getCode();
    }

    @Override
    public Example15JpaAttributeConverter.Status convertToEntityAttribute(String code) {
        return Objects.isNull(code) ? null : Example15JpaAttributeConverter.Status.codeToStatus(code);
    }
}
