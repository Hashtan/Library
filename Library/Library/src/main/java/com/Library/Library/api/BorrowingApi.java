package com.Library.Library.api;

import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.manager.BorrowingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/borrowing")
public class BorrowingApi {
    private BorrowingManager borrowings;

    @Autowired
    public BorrowingApi(BorrowingManager borrowings) {
        this.borrowings = borrowings;
    }

    @GetMapping("/all")
    public Iterable<Borrowing> getAll() {
        return borrowings.findAll();
    }

    @PostMapping
    public Borrowing addBook(@RequestBody Borrowing borrowing) {
        return borrowings.save(borrowing);
    }

    @PutMapping
    public Borrowing updateBook(@RequestBody Borrowing borrowing) {
        return borrowings.save(borrowing);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long index) {
        borrowings.deleteById(index);
    }

    @GetMapping
    public Optional<Borrowing> getById(@RequestParam Long index) {
        return borrowings.findById(index);
    }
}

