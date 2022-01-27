package com.getabook.domain.company.repository;

import com.getabook.domain.company.enitity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
