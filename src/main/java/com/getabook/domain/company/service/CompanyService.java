package com.getabook.domain.company.service;

import com.getabook.domain.company.dto.CompanyDto;
import com.getabook.domain.company.enitity.Company;
import com.getabook.domain.company.enitity.CompanyAccount;
import com.getabook.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public CompanyDto createCompany(CompanyDto companyDTO) {
        final Company company = dtoToCompany(companyDTO);
        final CompanyAccount account = CompanyAccount.builder()
                .company(company)
                .cashBalance(BigDecimal.ZERO)
                .build();
        company.setCompanyAccount(account);
        companyRepository.save(company);
        return companyToDto(company);
    }

    private Company dtoToCompany(CompanyDto companyDTO) {
        return Company.builder().name(companyDTO.getName()).build();
    }

    private CompanyDto companyToDto(Company company) {
        return CompanyDto.builder().name(company.getName()).build();
    }
}
