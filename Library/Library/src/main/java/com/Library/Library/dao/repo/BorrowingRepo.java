package com.Library.Library.dao.repo;

import com.Library.Library.dao.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BorrowingRepo extends JpaRepository <Borrowing, Long> {
      Iterable<Borrowing> findByUserId(Long id);
      Iterable<Borrowing> findByBookId(Long id);
      Iterable <Borrowing> findByBorrowEndNull();
      Iterable <Borrowing> findByUserIdAndBorrowEndNull(Long id);
}
