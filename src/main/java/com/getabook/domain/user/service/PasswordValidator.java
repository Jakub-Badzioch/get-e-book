package com.getabook.domain.user.service;

import com.getabook.domain.exception.ApplicationException;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    public void validate(String password) {
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
