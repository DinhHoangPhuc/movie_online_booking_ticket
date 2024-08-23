package com.online_booking_ticket.movie_online_booking_ticket.customAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "Trường này đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    FieldType fieldType();

    public enum FieldType {
        EMAIL, SDT
    }
}
