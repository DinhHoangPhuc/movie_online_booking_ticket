package com.online_booking_ticket.movie_online_booking_ticket.customAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatValidator implements ConstraintValidator<ValidDateFormat, Date> {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public boolean isValid(Date dateOfBirth, ConstraintValidatorContext context) {
        if (dateOfBirth == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        sdf.setLenient(false);
        try {
            sdf.format(dateOfBirth);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
