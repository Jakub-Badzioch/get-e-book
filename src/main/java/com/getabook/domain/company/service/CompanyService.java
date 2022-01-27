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
    private final CompanyMapper companyMapper;

    @Transactional
    public CompanyDto createCompany(CompanyDto companyDto) {
        final Company company = companyMapper.dtoToCompany(companyDto);
        final CompanyAccount account = CompanyAccount.builder()
                .company(company)
                .cashBalance(BigDecimal.ZERO)
                .build();
        company.setCompanyAccount(account);
        companyRepository.save(company);
        return companyMapper.companyToDto(company);
    }
}
