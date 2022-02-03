package com.getabook.domain.company.repository;

import com.getabook.domain.company.enitity.CompanyRole;
import com.getabook.domain.user.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRoleRepository extends JpaRepository<CompanyRole, Long> {

    boolean existsByUser(User user);

}
