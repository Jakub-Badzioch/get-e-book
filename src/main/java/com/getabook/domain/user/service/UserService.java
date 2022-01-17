package com.getabook.domain.user.service;

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
        final String login = userDto.getLogin();
        if (login.length() < 8) {
            throw new RuntimeException("Login is too short. Login: " + login);
        }
    }
}
