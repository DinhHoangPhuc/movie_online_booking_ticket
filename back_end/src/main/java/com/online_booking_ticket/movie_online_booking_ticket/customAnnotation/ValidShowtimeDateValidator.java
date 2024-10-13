package com.online_booking_ticket.movie_online_booking_ticket.customAnnotation;

import com.online_booking_ticket.movie_online_booking_ticket.execptionHandler.InvalidShowtimeDateException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidShowtimeDateValidator implements ConstraintValidator<ValidShowtimeDate, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()){
            throw new InvalidShowtimeDateException("Ngày chiếu không được để trống");
        }

        try {
            LocalDate showtimeDate = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
            if (showtimeDate.isAfter(LocalDate.now()) || showtimeDate.isEqual(LocalDate.now())) {
                return true;
            } else {
                throw new InvalidShowtimeDateException("Ngày chiếu phải sau ngày hiện tại");
            }
        } catch (DateTimeParseException e) {
            throw new InvalidShowtimeDateException("Ngày chiếu không đúng định dạng");
        }
    }
}
