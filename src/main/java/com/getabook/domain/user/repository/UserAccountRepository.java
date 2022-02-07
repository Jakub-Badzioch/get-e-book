package com.getabook.domain.user.repository;

import com.getabook.domain.user.enitity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
