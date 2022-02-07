package com.getabook.domain.user.service;

import com.getabook.domain.company.repository.CompanyRoleRepository;
import com.getabook.domain.company.service.CompanyService;
import com.getabook.domain.exception.ApplicationException;
import com.getabook.domain.user.dto.UserDto;
import com.getabook.domain.user.enitity.User;
import com.getabook.domain.user.mapper.UserMapper;
import com.getabook.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordValidator passwordValidator;
    private final CompanyService companyService;
    private final CompanyRoleRepository companyRoleRepository;

    public UserDto register(UserDto userDto) {
        this.passwordValidator.validate(userDto.getPassword());
        final User user = this.userMapper.toEntity(userDto);
        this.userRepository.save(user);
        return this.userMapper.toDto(user);
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ApplicationException("User doesn't exist"));
    }

}
