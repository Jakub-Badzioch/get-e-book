package com.getabook.domain.user.service;

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

    public UserDto register(UserDto userDto) {
        validate(userDto);
        final User user = userMapper.toEntity(userDto);
        userRepository.save(user); //obiekt zmiennej user zostanie zaktualizowany o id
        return userMapper.toDto(user);
    }

    private void validate(UserDto userDto) {
        final String password = userDto.getPassword();
        containsLowerCaseLetter(password);
        containsUpperCaseLetter(password);
        containsInteger(password);
    }

    private void containsInteger(String password){
        final boolean match = password.chars().anyMatch(Character::isDigit);
        if (!match){
            throw new ApplicationException("Password must contains at least one integer.");
        }
    }

    private void containsUpperCaseLetter(String password){
        final boolean match = password.chars().anyMatch(Character::isUpperCase);
        if (!match){
            throw new ApplicationException("Password must contains at least one uppercase letter.");
        }
    }

    private void containsLowerCaseLetter(String password){
        final boolean match = password.chars().anyMatch(Character::isLowerCase);
        if (!match){
            throw new ApplicationException("Password must contains at least one lowercase letter.");
        }
    }
}
