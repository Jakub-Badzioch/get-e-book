package com.getabook.domain.company.service;

import com.getabook.domain.company.dto.CompanyDto;
import com.getabook.domain.company.enitity.Company;
import com.getabook.domain.company.enitity.CompanyAccount;
import com.getabook.domain.company.repository.CompanyRepository;
import com.getabook.domain.exception.ApplicationException;
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
        final Company company = companyMapper.toEntity(companyDto);
        createCompanyAccount(company);
        companyRepository.save(company);
        return companyMapper.toDto(company);
    }

    public Company getCompany(Long id){
       return companyRepository.findById(id)
                .orElseThrow(() -> new ApplicationException("Company doesn't exist"));
    }

    private void createCompanyAccount(Company company) {
        final CompanyAccount account = CompanyAccount.builder()
                .company(company)
                .cashBalance(BigDecimal.ZERO)
                .build();
        company.setCompanyAccount(account);
    }
}
