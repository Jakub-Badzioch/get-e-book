package com.getabook.domain.user.service;

import com.getabook.domain.company.dto.CreateRoleDto;
import com.getabook.domain.company.enitity.Company;
import com.getabook.domain.company.enitity.CompanyRole;
import com.getabook.domain.company.enitity.Role;
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

    public void addUserToCompany(CreateRoleDto createRoleDto) {
        // sprawdź czy istnieje taki user
        final User user = this.getUser(createRoleDto.getEmail());
        // sprawdz czy istnieje takie company
        final Company company = companyService.getCompany(createRoleDto.getCompanyId());
        // sprawdz czy uzytkownik czasem juz nie jest przypisany do innej firmy
        final boolean userAlreadyHasCompany = companyRoleRepository.existsByCompany(company);
        if (userAlreadyHasCompany) {
            throw new ApplicationException("This user is already merged with other company");
        }

        final CompanyRole administrator = CompanyRole.builder()
                .user(user)
                .company(company)
                .role(Role.USER)
                .build();
        companyRoleRepository.save(administrator);
    }
}
