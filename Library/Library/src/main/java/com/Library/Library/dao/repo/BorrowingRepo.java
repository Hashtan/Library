package com.Library.Library.dao.repo;

import com.Library.Library.dao.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepo extends JpaRepository <Borrowing, Long> {
}
