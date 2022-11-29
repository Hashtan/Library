package com.Library.Library.api;

import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.manager.BorrowingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrowings")
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
    public Borrowing addBorrow(@RequestBody Borrowing borrowing) {
        return borrowings.save(borrowing);
    }

    @PutMapping
    public Borrowing updateBorrow(@RequestBody Borrowing borrowing) {
        return borrowings.save(borrowing);
    }

    @DeleteMapping
    public void deleteBorrow(@RequestParam Long index) {
        borrowings.deleteById(index);
    }

    @GetMapping("/findbyid")
    public Optional<Borrowing> getById(@RequestParam Long index) {
        return borrowings.findById(index);
    }
    @GetMapping("/findbyuserid")
    public Iterable<Borrowing> getBorrowByUserId(@RequestParam Long index){
        return borrowings.findByUserId(index);
    }
    @GetMapping("/findbybookid")
    public Iterable<Borrowing> getBorrowByBookId(@RequestParam Long index){
        return borrowings.findByBookId(index);
    }
    @GetMapping("/getactivestatus/all")
    public Iterable<Borrowing> getAllActive (){
        return borrowings.findAllActive();
   }
    @GetMapping("/getactivestatus")
    public Iterable<Borrowing> getActiveById(@RequestParam Long index) {
        return borrowings.findActiveByUserId(index);
    }
}

