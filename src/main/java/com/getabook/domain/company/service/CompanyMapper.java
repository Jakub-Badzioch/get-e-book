package com.getabook.domain.company.service;

import com.getabook.domain.company.dto.CompanyDto;
import com.getabook.domain.company.enitity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company toEntity(CompanyDto companyDto) {
        return Company.builder()
                .name(companyDto.getName())
                .build();
    }

    public CompanyDto toDto(Company company) {
        return CompanyDto.builder()
                .name(company.getName())
                .build();
    }
}
