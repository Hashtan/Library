package com.Library.Library.manager;

import com.Library.Library.dao.entity.Book;
import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.dao.repo.BookRepo;
import com.Library.Library.dao.repo.BorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class BorrowingManager {

    private BorrowingRepo borrowingRepo;

    @Autowired
    public BorrowingManager (BorrowingRepo borrowingRepo){
        this.borrowingRepo = borrowingRepo;
    }

    public Optional<Borrowing> findById(Long id) {
        return borrowingRepo.findById(id);
    }

    public Iterable<Borrowing> findAll() {
        return borrowingRepo.findAll();
    }

    public Borrowing save(Borrowing borrowing) {
        return borrowingRepo.save(borrowing);
    }

    public void deleteById(Long id) {
        borrowingRepo.deleteById(id);
    }

}