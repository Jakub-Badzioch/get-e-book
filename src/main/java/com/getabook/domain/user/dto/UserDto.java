package com.getabook.domain.user.dto;

import com.getabook.domain.company.enitity.CompanyRole;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String email;
    private CompanyRole companyRole;

}
