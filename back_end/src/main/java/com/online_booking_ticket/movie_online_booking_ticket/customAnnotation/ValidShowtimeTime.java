package com.online_booking_ticket.movie_online_booking_ticket.customAnnotation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidShowtimeTimeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidShowtimeTime {
    String message() default "Giờ chiếu không hợp lệ";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}

