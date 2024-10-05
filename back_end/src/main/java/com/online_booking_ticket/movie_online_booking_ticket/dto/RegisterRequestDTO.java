package com.online_booking_ticket.movie_online_booking_ticket.dto;

import java.time.LocalDate;

import com.online_booking_ticket.movie_online_booking_ticket.customAnnotation.Unique;
import com.online_booking_ticket.movie_online_booking_ticket.customAnnotation.ValidDateFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
public class RegisterRequestDTO {

    @NotBlank(message = "Họ tên không được để trống")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Họ tên không hợp lệ")
    private String name;

    @Email(message = "Email không hợp lệ")
    @Unique(fieldType = Unique.FieldType.EMAIL, message = "Email đã tồn tại")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Mật khẩu phải chứa ít nhất 8 ký tự, bao gồm chữ cái và số")
    private String password;

    @ValidDateFormat(message = "Ngày sinh không hợp lệ")
    private LocalDate dateOfBirth;
}
