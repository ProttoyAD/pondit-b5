package com.rakib.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {

    String username;
    @NotBlank(message = "Please enter email address")
    @Email(message = "Email address is not valid")
    String email;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{6}$",
            message = "Must contain one uppercase letter, one lower case letter, one special character and one digit, and must be at least 6 characters long")
    String password;
    String rePassword;
}
