package com.getabook.domain.user.dto;

import com.getabook.domain.company.enitity.CompanyRole;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @Min(value = 8, message = "Login should not be less than 8")
    private String login;
    @Min(value = 10, message = "Password should not be less than 10")
    private String password;
    @Email(message = "Email is invalid.")
    private String email;
    private CompanyRole companyRole;

}
