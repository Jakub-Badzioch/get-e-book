package com.getabook.domain.user.controller;

import com.getabook.domain.user.dto.UserDto;
import com.getabook.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody @Valid UserDto userDto) {
        return userService.register(userDto);
    }
}