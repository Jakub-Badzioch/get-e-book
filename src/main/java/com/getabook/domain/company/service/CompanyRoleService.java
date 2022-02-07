package com.getabook.domain.company.service;

import com.getabook.domain.company.dto.CreateRoleDto;
import com.getabook.domain.company.enitity.Company;
import com.getabook.domain.company.enitity.CompanyRole;
import com.getabook.domain.company.enitity.Role;
import com.getabook.domain.company.repository.CompanyRoleRepository;
import com.getabook.domain.exception.ApplicationException;
import com.getabook.domain.user.enitity.User;
import com.getabook.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyRoleService {

    private final CompanyRoleRepository companyRoleRepository;
    private final UserService userService;
    private final CompanyService companyService;

    public void createAdministrator(CreateRoleDto createRoleDto) {
        createCompanyRole(createRoleDto, Role.ADMINISTRATOR);
    }

    public void createUser(CreateRoleDto createRoleDto) {
        createCompanyRole(createRoleDto, Role.USER);
    }

    private void createCompanyRole(CreateRoleDto createRoleDto, Role role){
        final User user = userService.getUser(createRoleDto.getEmail());
        final Company company = companyService.getCompany(createRoleDto.getCompanyId());

        final boolean userAlreadyHasRole = companyRoleRepository.existsByUser(user);
        if (userAlreadyHasRole) {
            throw new ApplicationException("CompanyRole for this user already exists");
        }
        final CompanyRole administrator = CompanyRole.builder()
                .user(user)
                .company(company)
                .role(role)
                .build();
        companyRoleRepository.save(administrator);
    }
}
