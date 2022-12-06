package com.Library.Library.manager;

import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.dao.repo.BorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowingManager {
    @Autowired
    private final BorrowingRepo borrowingRepo;

    @Autowired
    public BorrowingManager(BorrowingRepo borrowingRepo) {
        this.borrowingRepo = borrowingRepo;
    }

    public Optional<Borrowing> findById(Long id) {
        return borrowingRepo.findById(id);
    }

    public Iterable<Borrowing> findAll() {
        return borrowingRepo.findAll();
    }

    public Borrowing save(Borrowing borrowing) {
        borrowing.setBorrowStart(LocalDate.now());
        borrowing.setExpectedReturnDate(LocalDate.now().plusMonths(3));
        borrowing.getBook().setActiveStatus(false);
        return borrowingRepo.save(borrowing);
    }
    public Borrowing update(Borrowing borrowing) {
        return borrowingRepo.save(borrowing);
    }
    public Borrowing returnBookById(Long id) {
        Optional<Borrowing> returnBorrowing = findById(id);
        Borrowing borrowing = returnBorrowing.stream().findFirst().orElse(null);
        assert borrowing != null;
        borrowing.setBorrowEnd(LocalDate.now());
        borrowing.getBook().setActiveStatus(true);
        return borrowingRepo.save(borrowing);
    }

    public void deleteById(Long id) {
        borrowingRepo.deleteById(id);
    }


    public Iterable<Borrowing> findByUserId(Long id) {
        return borrowingRepo.findByUserId(id);
    }
    public Iterable<Borrowing> findByBookId(Long id){
        return borrowingRepo.findByBookId(id);
    }
    public Iterable<Borrowing> findAllActive() {
        return borrowingRepo.findByBorrowEndNull();
    }
    public Iterable<Borrowing> findActiveByUserId(Long id) {
        return borrowingRepo.findByUserIdAndBorrowEndNull(id);
    }
}

