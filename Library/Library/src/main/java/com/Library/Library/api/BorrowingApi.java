package com.Library.Library.api;

import com.Library.Library.dao.entity.Borrowing;
import com.Library.Library.manager.BorrowingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingApi {
    private BorrowingManager borrowingManager;

    @Autowired
    public BorrowingApi(BorrowingManager borrowings) {
        this.borrowingManager = borrowings;
    }

    @GetMapping("/all")
    public Iterable<Borrowing> getAll() {
        return borrowingManager.findAll();
    }

    @PostMapping
    public Borrowing addBorrow(@RequestBody Borrowing borrowing) {
        return borrowingManager.save(borrowing);
    }

    @PutMapping
    public Borrowing updateBorrow(@RequestBody Borrowing borrowing) {
        return borrowingManager.update(borrowing);
    }

    @DeleteMapping
    public void deleteBorrow(@RequestParam Long index) {
        borrowingManager.deleteById(index);
    }

    @GetMapping("/findbyid")
    public Optional<Borrowing> getById(@RequestParam Long index) {
        return borrowingManager.findById(index);
    }
    @GetMapping("/findbyuserid")
    public Iterable<Borrowing> getBorrowByUserId(@RequestParam Long index){
        return borrowingManager.findByUserId(index);
    }
    @GetMapping("/findbybookid")
    public Iterable<Borrowing> getBorrowByBookId(@RequestParam Long index){
        return borrowingManager.findByBookId(index);
    }
    @GetMapping("/getactivestatus/all")
    public Iterable<Borrowing> getAllActive (){
        return borrowingManager.findAllActive();
   }
    @GetMapping("/getactivestatus")
    public Iterable<Borrowing> getActiveById(@RequestParam Long index) {
        return borrowingManager.findActiveByUserId(index);
    }

    @PutMapping("/returnbyid")
    public Borrowing returnById (@RequestParam Long index) {
        return borrowingManager.returnBookById(index);
    }
}

