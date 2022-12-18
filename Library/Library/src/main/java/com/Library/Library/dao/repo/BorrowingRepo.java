package com.Library.Library.dao.repo;

import com.Library.Library.dao.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BorrowingRepo extends JpaRepository <Borrowing, Long> {
      Iterable<Borrowing> findByUserId(Long id);
      Iterable<Borrowing> findByBookId(Long id);
      Iterable <Borrowing> findByBorrowEndNull();
      Iterable <Borrowing> findByUserIdAndBorrowEndNull(Long id);
}
