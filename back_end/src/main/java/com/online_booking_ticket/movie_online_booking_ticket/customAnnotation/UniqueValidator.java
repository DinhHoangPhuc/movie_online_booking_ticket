package com.online_booking_ticket.movie_online_booking_ticket.customAnnotation;

import com.online_booking_ticket.movie_online_booking_ticket.repositories.UserRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueValidator implements ConstraintValidator<Unique, String> {
    private Unique.FieldType fieldType;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.fieldType = constraintAnnotation.fieldType();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return switch (fieldType) {
            case EMAIL -> userRepo.findByEmail(value).isEmpty();
            case SDT -> userRepo.findByPhoneNumber(value).isEmpty();
        };

    }
}
