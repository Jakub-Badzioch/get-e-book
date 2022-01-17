package com.getabook.domain.user.repository;

import com.getabook.domain.user.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
