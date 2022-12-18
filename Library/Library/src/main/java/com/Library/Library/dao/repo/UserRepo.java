package com.Library.Library.dao.repo;

import com.Library.Library.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
