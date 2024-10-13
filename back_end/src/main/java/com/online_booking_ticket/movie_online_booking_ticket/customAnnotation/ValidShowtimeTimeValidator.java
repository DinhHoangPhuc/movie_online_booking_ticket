package com.online_booking_ticket.movie_online_booking_ticket.customAnnotation;

import com.online_booking_ticket.movie_online_booking_ticket.execptionHandler.InvalidShowtimeDateException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidShowtimeTimeValidator implements ConstraintValidator<ValidShowtimeTime, String> {

    @Override
    public boolean isValid(String time, ConstraintValidatorContext context) {
        if (time == null || time.isEmpty()) {
            throw new InvalidShowtimeDateException("Giờ chiếu không được để trống");
        }

        try {
            LocalTime showtimeTime = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
            if(showtimeTime.isAfter(LocalTime.now()) || showtimeTime.equals(LocalTime.now())){
                return true;
            } else {
                throw new InvalidShowtimeDateException("Giờ chiếu phải sau giờ hiện tại");
            }
        } catch (DateTimeParseException e) {
            throw new InvalidShowtimeDateException("Giờ chiếu không đúng định dạng");
        }
    }
}
