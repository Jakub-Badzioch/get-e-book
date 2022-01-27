package com.getabook.domain.user.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @Length(min = 8, message = "Login should not be less than 8")
    private String login;
    @Length(min = 10, message = "Password should not be less than 10")
    private String password;
    @Email(message = "Email is invalid.")
    private String email;

}
