package com.getabook.domain.company.controller;

import com.getabook.domain.company.dto.CompanyDto;
import com.getabook.domain.company.dto.CreateRoleDto;
import com.getabook.domain.company.service.CompanyRoleService;
import com.getabook.domain.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("company")
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyRoleService companyRoleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto register(@RequestBody CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAdministrator(@RequestBody CreateRoleDto createRoleDto) {
        companyRoleService.createCompanyRole(createRoleDto);
    }
}
